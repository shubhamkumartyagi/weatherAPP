package com.weather.process;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.weather.command.WeatherForecastCommand;
import com.weather.domain.GetWeatherRequest;
import com.weather.domain.GetWeatherResponse;

//TODO: Use Hystrix Annotation instead of old command way.
@Component
public class WeatherProcess {

	private static final String WEATHER_FORECAST_COMMAND = "weatherForecastCommand";

	@Autowired
	ApplicationContext applicationContext;

	public GetWeatherResponse getWeather(String zipCode, String country) {
		GetWeatherResponse zipAndCountryResponse = new GetWeatherResponse();
		GetWeatherRequest zipAndCountryRequest = new GetWeatherRequest();
		zipAndCountryRequest.setZip(zipCode);
		zipAndCountryRequest.setCountryCode(country);
		WeatherForecastCommand weatherCommand = (WeatherForecastCommand) applicationContext
				.getBean(WEATHER_FORECAST_COMMAND, zipAndCountryRequest);
		Future<GetWeatherResponse> future = weatherCommand.queue();
		try {
			zipAndCountryResponse = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO add some logging configuration and write everything to a file
			e.printStackTrace();
		}
		return zipAndCountryResponse;
	}

}
