package com.weather.controller;

import com.weather.process.WeatherProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.domain.GetWeatherJSONResponse;
import com.weather.domain.GetWeatherResponse;
import com.weather.domain.restAPI.SingleWeatherDetails;
import com.weather.util.WeatherControllerUtility;

/**
 * This class contains all the controller methods which should be call from UI
 * to fetch details about the weather.
 * 
 * @author shubham kumar
 *
 */
@RestController
public class WeatherController {

	@Autowired
	private WeatherProcess weatherProcess;

	/**
	 * It takes zip code and country as a parameter and then delegates the call to
	 * business layer.
	 * 
	 * @return coolest temperature of tomorrow
	 */
	@RequestMapping(value = "/getWeather", method = RequestMethod.GET)
	GetWeatherJSONResponse getZipCodeAndReturnWeather(
			@RequestParam(value = "zip", defaultValue = "20001") String zipCode,
			@RequestParam(value = "countryCode", defaultValue = "us") String countryCode) {
		GetWeatherJSONResponse jsonResponse = new GetWeatherJSONResponse();
		GetWeatherResponse response = weatherProcess.getWeather(zipCode, countryCode);
		SingleWeatherDetails minimumTemperature = WeatherControllerUtility.getCoolestWeather(response.getDetailedWeather());
		jsonResponse.setCoolestTemperature(
				minimumTemperature.getDt_txt() + " at temperature is: " + minimumTemperature.getMain().getTemp());
		jsonResponse.setCode(response.getResponseCode());
		return jsonResponse;
	}

}
