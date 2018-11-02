package com.weather.domain.restAPI;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleWeatherDetails {
	
	private long dt;
	
	private List<TemperatureDetails> main;
	
	private String dt_txt;

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public List<TemperatureDetails> getMain() {
		return main;
	}

	public void setTempratureDetails(List<TemperatureDetails> main) {
		this.main = main;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

}
