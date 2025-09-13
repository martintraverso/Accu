package com.martintraverso.AccuWeather.Request;

import com.fasterxml.jackson.databind.JsonNode;
import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Utilities.HttpMethods;

import java.util.Map;

public interface AccuWeatherRequest {
    String getEndpoint() throws Exception;

    HttpMethods getHttpMethod();

    Map<String, String> getParameters();

    AccuWeatherResponse buildFromJson(JsonNode node);
}
