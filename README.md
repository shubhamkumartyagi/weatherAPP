# weatherAPP
An app to display weather for a given zip code of a US city. There is a simple UI page which makes an ajax call to our rest controller to fetch minimum temperature for a given US zip code.

## About the project flow
This project has a Spring controller to process request coming from UI.
Then a business logic to process the request that is coming from the controller.
There is an external REST API call to 'open weather' using netflix hystrix which also helps us understand third party calls handling.

## How to run
1) Eclipse: You can import this project directly into your Eclipse under the name 'weatherAPP' and simply run as a Spring Boot application to get things working.
Hit 'http:localhost:8080/index.html' and you are good to go. 
2) Executable jar file: Run the package using maven by the following command: 'mvn install' in the main directory where your pom file is located and after the successful execution you should be able to find see jar in target folder.

### Sample Request and Response
![sample_request_response](https://user-images.githubusercontent.com/44669879/47965577-f7031980-e06e-11e8-8d66-5b08214dd49a.png)


#### Known issues:
1) This application is well test using multiple zip code. But there may be a case that it does not work for the first time because of hystrix issue 'https://stackoverflow.com/questions/36071841/spring-cloud-hystrix-fails-at-first-command-call'.
2) OpenWeatherMap API that is being used here to fetch weather may not respond as it does not guarantee 99% availability because of free usage. Try again if external API is not responding.
3) Weather forecast from OpenWeatherMap API is not provided on a hourly instead they provide forecast of every three hours.
So the sorting logic is not done on hourly basis instead on quaterly basis.

