package com.weather.domain;

import lombok.Data;

@Data
public class GetWeatherJSONResponse {
	
	/**
	 *  code returned from external rest API so that it can be handles on UI side to display a proper error message.
	 */
	private String code;
	
	/**
	 * coolest temperature and time
	 */
	private String coolestTemperature;
}
