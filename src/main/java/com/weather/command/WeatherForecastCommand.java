package com.weather.command;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.weather.domain.GetWeatherRequest;

/**
 * Hytrix Command class to execute the REST API connection as an asynchronous
 * call.
 * 
 * @author shubham kumar
 *
 */
@Component
@Scope("prototype")
public class WeatherForecastCommand extends HystrixCommand<String> {

	private static final String APPID = "&APPID=";

	private static final String VERSION_AND_END_POINT = "2.5/forecast?zip=";

	/* Request for the external call */
	private GetWeatherRequest zipAndCountry;

	/* Open Map REST URL */
	private static final String OPEN_WEATHER_MAP_URL = "open.weather.map.url";

	/* Open Map REST APP ID */
	private static final String OPEN_WEATHER_MAP_KEY = "open.weather.map.key";

	/*
	 * Dependency to read application properties values.
	 */
	@Autowired
	private Environment env;

	public WeatherForecastCommand(GetWeatherRequest zipAndCountry) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleWeatherApp"));
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.ExampleWeatherApp.execution.isolation.thread.timeoutInMilliseconds", new Long(30000));
		this.zipAndCountry = zipAndCountry;
	}

	@Override
	public String run() throws Exception {
		try {
			HttpClient client = HttpClients.createDefault();
			HttpGet request = new HttpGet(
					env.getProperty(OPEN_WEATHER_MAP_URL) + VERSION_AND_END_POINT + zipAndCountry.getZip() + ","
							+ zipAndCountry.getCountryCode() + APPID +  env.getProperty(OPEN_WEATHER_MAP_KEY));
			request.setHeader("Accept", "application/json");
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected String getFallback() {
		return "Connection issue";
	}

}
