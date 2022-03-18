package com.weather.domain;

import lombok.Data;

/**
 * Domain object class for the Request object to Open Map REST API
 * @author shubham kumar
 *
 */
@Data
public class GetWeatherRequest {

	/* zip code of the city for the given request */
	private String zip;
	
	/* country code of the city for the given request */
	private String countryCode;
}
