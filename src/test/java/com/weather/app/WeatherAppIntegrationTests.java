package com.weather.app;

import com.weather.app.common.SimpleHttpClient;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class WeatherAppIntegrationTests {

    public static final DockerImageName MOCKSERVER_IMAGE = DockerImageName.parse("jamesdbloom/mockserver:mockserver-5.13.0");

    @Rule
    public MockServerContainer mockServer = new MockServerContainer(MOCKSERVER_IMAGE);

    @Test
    public void createMockHttpServer() throws IOException {
        mockServer.start();

        String expectedBody = "Hello World!";

        MockServerClient mockServerClient = new MockServerClient(mockServer.getHost(), mockServer.getServerPort());

        assertTrue(mockServerClient.isRunning(), "Mockserver running");

        mockServerClient
                .when(request().withPath("/hello"))
                .respond(response().withBody(expectedBody));

        assertThat("MockServer returns correct result",
                SimpleHttpClient.responseFromMockserver(mockServer, "/hello"),
                equalTo(expectedBody)
        );
    }

}
