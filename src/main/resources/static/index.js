/**
 * 
 */

function onClick(){
	$.ajax({
		url : "http://localhost:8080/getWeather",
		data : { zip: $("#zip").val(), countryCode: $("#countryCode").val() },
		success : function(result) {
			$("#resultpanel").html(result.coolestTemperature);
		}
	});
};