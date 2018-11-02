package com.weather.domain;

import java.util.List;

import com.weather.domain.restAPI.SingleWeatherDetails;

public class GetWeatherResponse {
	
	/* the response code return from external service*/
	private String responseCode;
	
	/* the response body return from external service*/
	private List<SingleWeatherDetails> detailedWeather;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<SingleWeatherDetails> getResponseBody() {
		return detailedWeather;
	}

	public void setResponseBody(List<SingleWeatherDetails> detailedWeather) {
		this.detailedWeather = detailedWeather;
	}

}
