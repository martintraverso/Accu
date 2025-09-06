package com.martintraverso.AccuWeather;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;
import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Response.FailedResponse;
import com.martintraverso.AccuWeather.Response.Location.AdminArea;
import com.martintraverso.AccuWeather.Response.Location.AdminAreaListResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class AccuWeatherCall {

    private final HttpClient client;
    private final ObjectMapper mapper;
    String baseUrl = "http://dataservice.accuweather.com/";
    String apiKey = System.getenv("ACCUWEATHER_API_KEY");

    public AccuWeatherCall() {
        client = HttpClient.newHttpClient();
        mapper = new ObjectMapper();
    }

    public AccuWeatherResponse call(AccuWeatherRequest accuWeatherRequest) {
        try {
            if (apiKey == null) {
                throw new IllegalStateException("ACCUWEATHER_API_KEY environment variable is required");
            }

            String endpoint = baseUrl + accuWeatherRequest.getEndpoint() + "?apikey=" + apiKey;

            // @todo I need to work in different http methods.
            // I do have the method in the Request object.
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "identity")
                    .header("Accept-Language", "es-ES")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // @todo this is a level elevated from wrong, but it is working in this first call.
            // Need to understand what to make this correctly.
            if (response.statusCode() == 200) {
                List<AdminArea> ListOfResponses = mapper.readValue(response.body(), new TypeReference<List<AdminArea>>() {
                });
                return new AdminAreaListResponse(ListOfResponses);
            } else {
                throw new RuntimeException("API call failed: " + response.statusCode());
            }
        } catch (Exception e) {
            return new FailedResponse(e.getMessage(), 500);
        }
    }
}
