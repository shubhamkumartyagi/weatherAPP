package com.weather.domain.restAPI;

import java.util.Date;
import java.util.List;

public class SingleWeatherDetails {
	
	private String dt;
	
	private List<TemperatureDetails> tempratureDetails;
	
	private Date dt_txt;

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public List<TemperatureDetails> getTempratureDetails() {
		return tempratureDetails;
	}

	public void setTempratureDetails(List<TemperatureDetails> tempratureDetails) {
		this.tempratureDetails = tempratureDetails;
	}

	public Date getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(Date dt_txt) {
		this.dt_txt = dt_txt;
	}

}
