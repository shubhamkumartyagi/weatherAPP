package com.weather.domain;

public class GetWeatherJSONResponse {
	
	/**
	 *  code returned from external rest API so that it can be handles on UI side to display a proper error message.
	 */
	private String code;
	
	/**
	 * coolest temperature and time
	 */
	private String coolestTemperature;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCoolestTemperature() {
		return coolestTemperature;
	}

	public void setCoolestTemperature(String coolestTemperature) {
		this.coolestTemperature = coolestTemperature;
	}

}
