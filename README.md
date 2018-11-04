# weatherAPP
An app to display weather for a given zip code of a US city. There is a simple UI page which makes an ajax call to our rest controller to fetch minimum temperature for a given US zip code.


This project has a Spring controller to process request coming from UI.
Then a business logic to process the request that is coming from the controller.
There is an external REST API call to 'open weather' using netflix hystrix which also helps us understand third party calls handling.

You can import this project directly into your Eclipse under the name 'weatherAPP' and simply run as a Spring Boot application to get things working.
Hit 'http:localhost:8080/index.html' and you are good to go. 


Things to watch out for(or known issues):
1) This application is well test using multiple zip code. But there may be a case that it does not work for the first time because of hystrix issue 'https://stackoverflow.com/questions/36071841/spring-cloud-hystrix-fails-at-first-command-call'.
2) OpenWeatherMap API that is being used here to fetch weather may not respond as it does not guarantee 99% availability because of free usage. Try again if external API is not responding.
3) Weather forecast from OpenWeatherMap API is not provided on a hourly instead they provide forecast of every three hours.
So the sorting logic is not done on hourly basis instead on quaterly basis.

