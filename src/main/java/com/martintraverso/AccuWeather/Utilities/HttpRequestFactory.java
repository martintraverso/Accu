package com.martintraverso.AccuWeather.Utilities;

import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;

import java.net.URI;
import java.net.http.HttpRequest;

public abstract class HttpRequestFactory {
    static String baseUrl = "https://dataservice.accuweather.com/";
    static String apiKey = System.getenv("ACCUWEATHER_API_KEY");

    public static HttpRequest create(AccuWeatherRequest accuWeatherRequest) throws Exception {

        if (apiKey == null) {
            throw new IllegalStateException("ACCUWEATHER_API_KEY environment variable is required");
        }

        String endpoint = baseUrl + accuWeatherRequest.getEndpoint();

        if (accuWeatherRequest.getHttpMethod() == HttpMethods.GET) {
            return HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .header("Accept", "*/*")
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Accept-Encoding", "identity")
                    .header("Accept-Language", "es-ES")
                    .build();
        }
        return null;
    }
}
