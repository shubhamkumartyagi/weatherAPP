package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.domain.GetWeatherResponse;
import com.weather.process.WeatherProcess;

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
	 * This method provides the detailed weather report. It takes zip code as an
	 * parameter and then return you the weather details of tomorrow.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getWeather", method = RequestMethod.GET)
	GetWeatherResponse getZipCodeAndReturnWeather(@RequestParam(value = "zip", defaultValue = "20001") String zipCode,
			@RequestParam(value = "country", defaultValue = "us") String countryCode) {
		GetWeatherResponse respone = weatherProcess.getWeather("20001", "us");
		return respone;
	}

}
