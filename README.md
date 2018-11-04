# weatherAPP
An app to display weather for a given zip code of an US city. There is an simple UI page which makes an ajax call to our rest controller to fetch minimum temperature for a given US zip code.


This project has a Spring controller to process request coming from UI.
Then a business logic to process the request that is coming from controller.
There is an external REST API call to 'open weather' using netflix hystrix which also helps us understand third party calls handling.

You can import this project directly into your Eclipse under the name 'weatherAPP' and just simply run as a Spring Boot application to get things working.
Hit 'http:localhost:8080/index.html' and you are good to go. 
