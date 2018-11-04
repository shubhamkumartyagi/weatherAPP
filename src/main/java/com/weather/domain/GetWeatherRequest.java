package com.weather.domain;

/**
 * Domain object class for the Request object to Open Map REST API
 * @author shubham kumar
 *
 */
public class GetWeatherRequest {

	/* zip code of the city for the given request */
	private String zip;
	
	/* country code of the city for the given request */
	private String countryCode;

	/* get the Zip Code of the given city */
	public String getZip() {
		return zip;
	}

	/* set the Zip Code of the given city */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/* get the country Code of the given city */
	public String getCountryCode() {
		return countryCode;
	}

	/* set the country Code of the given city */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
