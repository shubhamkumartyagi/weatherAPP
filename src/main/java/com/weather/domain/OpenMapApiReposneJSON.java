package com.weather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.domain.restAPI.SingleWeatherDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenMapApiReposneJSON {
	
	private String cod;
	
	private String message;
	
	private String cnt;
	
	private List<SingleWeatherDetails> detailedWeather;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public List<SingleWeatherDetails> getDetailedWeather() {
		return detailedWeather;
	}

	public void setDetailedWeather(List<SingleWeatherDetails> detailedWeather) {
		this.detailedWeather = detailedWeather;
	}

}
