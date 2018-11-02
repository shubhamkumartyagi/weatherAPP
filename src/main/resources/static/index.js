/**
 * 
 */

function onClick(){
	$.ajax({
		url : "http://localhost:8080/getWeather",
		data : { zip: $("#zip").val(), countryCode: $("#countryCode").val() },
		success : function(result) {
			$("#div1").html(result);
		}
	});
};