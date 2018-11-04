package com.weather.util;

import java.util.Comparator;

import com.weather.domain.restAPI.SingleWeatherDetails;

public class SortByTemperature implements Comparator<SingleWeatherDetails> {

	@Override
	public int compare(SingleWeatherDetails o1, SingleWeatherDetails o2) {
		if (Double.parseDouble(o1.getMain().getTemp()) > Double.parseDouble(o2.getMain().getTemp())) {
			return 1;
		} else {
			return -1;
		}
		
	}

}
