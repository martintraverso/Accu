package com.martintraverso.AccuWeather.Request;

import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Utilities.HttpMethods;

public interface AccuWeatherRequest {
    Class<? extends AccuWeatherResponse> getResponseClass();

    String getEndpoint() throws Exception;

    HttpMethods getHttpMethod();
}
