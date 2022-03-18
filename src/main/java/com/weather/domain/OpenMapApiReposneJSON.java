package com.weather.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.domain.restAPI.SingleWeatherDetails;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OpenMapApiReposneJSON{
	
	private String cod;
	
	private String message;
	
	private int cnt;
	
	private String country;
	
	private List<SingleWeatherDetails> list;


}
