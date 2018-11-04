# weatherAPP
An app to display weather for a given zip code of a US city. There is a simple UI page which makes an ajax call to our rest controller to fetch minimum temperature for a given US zip code.


This project has a Spring controller to process request coming from UI.
Then a business logic to process the request that is coming from the controller.
There is an external REST API call to 'open weather' using netflix hystrix which also helps us understand third party calls handling.

You can import this project directly into your Eclipse under the name 'weatherAPP' and just simply run as a Spring Boot application to get things working.
Hit 'http:localhost:8080/index.html' and you are good to go. 


Things to watch out for:
This application is well test using multiple zip code. But there may be a case that it does not work for the first time because of hystrix issue 'https://stackoverflow.com/questions/36071841/spring-cloud-hystrix-fails-at-first-command-call'.
Also, the OpenWeatherMap API that is being used here to fetch weather may not respond as it does not guarantee 99% availability because of free usage.
Please try multiple times if you don't the desired result.
