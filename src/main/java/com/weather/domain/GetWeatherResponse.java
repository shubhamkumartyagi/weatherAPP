package com.weather.domain;

import java.util.List;

import com.weather.domain.restAPI.SingleWeatherDetails;
import lombok.Data;

@Data
public class GetWeatherResponse {
	
	/* the response code return from external service*/
	private String responseCode;
	
	/* the response body return from external service*/
	private List<SingleWeatherDetails> detailedWeather;

}
