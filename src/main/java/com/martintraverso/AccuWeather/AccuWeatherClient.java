package com.martintraverso.AccuWeather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;
import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Response.FailedResponse;
import com.martintraverso.AccuWeather.Utilities.HttpRequestFactory;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccuWeatherClient {

    private final HttpClient client;
    private final ObjectMapper mapper;

    public AccuWeatherClient() {
        client = HttpClient.newHttpClient();
        mapper = new ObjectMapper();
    }

    public AccuWeatherResponse call(AccuWeatherRequest accuWeatherRequest) {
        try {
            HttpRequest request = HttpRequestFactory.create(accuWeatherRequest);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String body = response.body();
                JsonNode rootNode = mapper.readTree(body);
                return accuWeatherRequest.buildFromJson(rootNode);
            } else {
                throw new RuntimeException("API call failed: " + response.statusCode());
            }
        } catch (Exception e) {
            return new FailedResponse(e.getMessage(), 500);
        }
    }
}
