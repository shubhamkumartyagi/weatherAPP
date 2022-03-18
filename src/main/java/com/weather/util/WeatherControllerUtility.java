package com.weather.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;

import com.weather.domain.restAPI.SingleWeatherDetails;

public class WeatherControllerUtility {

	private static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";

	/**
	 * Util method to take all weather forecast for 5 days (our REST API is
	 * returning that only) and to find out the coolest temperature for tomorrow.
	 * 
	 * @return 
	 * 	the object with minimum temperature within whole data structure.
	 */
	public static SingleWeatherDetails getCoolestWeather(List<SingleWeatherDetails> weatherDetailesForecasted) {

		if (weatherDetailesForecasted == null) {
			return new SingleWeatherDetails();
		}

		List<SingleWeatherDetails> dateFilteredList = weatherDetailesForecasted.stream().filter(weather -> {
			try {
				Date dateFromAPI = DateUtils.parseDate(weather.getDt_txt(), DATE_PATTERN);
				Date datePlusOne = new Date();
				Calendar c = Calendar.getInstance(); 
				c.setTime(datePlusOne); 
				c.add(Calendar.DATE, 1);
				datePlusOne = c.getTime();
				return DateUtils.isSameDay(dateFromAPI, datePlusOne);
			} catch (ParseException e) {
				// TODO add logger and also write exception to a file
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
		
		return dateFilteredList.stream().min(new SortByTemperature()).get();
		
	}

}
