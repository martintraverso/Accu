package com.martintraverso.AccuWeather.Request;

import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Utilities.HttpMethods;

import java.util.Map;

public interface AccuWeatherRequest {
    Class<? extends AccuWeatherResponse> getResponseClass();

    String getEndpoint() throws Exception;

    HttpMethods getHttpMethod();

    Map<String, String> getParameters();
}
