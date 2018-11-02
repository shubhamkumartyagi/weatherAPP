package com.weather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.domain.restAPI.SingleWeatherDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenMapApiReposneJSON{
	
	private String cod;
	
	private String message;
	
	private int cnt;
	
	private String country;
	
	private List<SingleWeatherDetails> list;

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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<SingleWeatherDetails> getList() {
		return list;
	}

	public void setList(List<SingleWeatherDetails> list) {
		this.list = list;
	}

}
