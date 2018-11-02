package com.weather.process;

import com.weather.domain.GetWeatherResponse;

/**
 * This is a business logic class for weather app which connects to external services to fetch data.
 * 
 * External weather REST API used is: <a href="https://openweathermap.org/api">Open Weather Map</a>
 * @author shubham kumar
 *
 */
public interface WeatherProcess {

	/**
	 * This process method will perform the business logic for fetching the data for weather app and also
	 * map the same to domain object for our application.
	 * @param zipCode 
	 * @param country
	 * @return
	 * 	the detailed weather report
	 */
	public GetWeatherResponse getWeather(String zipCode, String country);
	
}
