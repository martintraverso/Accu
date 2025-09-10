package com.martintraverso.AccuWeather.Utilities;

import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;

import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public abstract class HttpRequestFactory {
    static String baseUrl = "https://dataservice.accuweather.com/";
    static String apiKey = System.getenv("ACCUWEATHER_API_KEY");

    public static HttpRequest create(AccuWeatherRequest accuWeatherRequest) throws Exception {

        if (apiKey == null) {
            throw new IllegalStateException("ACCUWEATHER_API_KEY environment variable is required");
        }

        String endpoint = getFullUrl(accuWeatherRequest.getEndpoint(), accuWeatherRequest.getParameters());

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

    private static String getFullUrl(String endpoint, Map<String, String> parameters) {

        if (parameters.isEmpty()) {
            return baseUrl + endpoint;
        }

        StringBuilder url = new StringBuilder(baseUrl + endpoint + "?");

        parameters.entrySet().stream()
                .filter(entry -> entry.getValue() != null) // Skip null values
                .forEach(entry -> {
                    url.append(entry.getKey())
                            .append("=")
                            .append(urlEncode(entry.getValue()))
                            .append("&");
                });

        // Remove last &
        if (url.charAt(url.length() - 1) == '&') {
            url.setLength(url.length() - 1);
        }

        return url.toString();
    }


    private static String urlEncode(String value) {
        try {
            return java.net.URLEncoder.encode(value, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return value;
        }
    }
}
