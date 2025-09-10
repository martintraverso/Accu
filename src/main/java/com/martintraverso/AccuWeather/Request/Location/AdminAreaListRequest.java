package com.martintraverso.AccuWeather.Request.Location;

import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;
import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Response.Location.AdminAreaListResponse;
import com.martintraverso.AccuWeather.Utilities.HttpMethods;

import java.util.Map;

public class AdminAreaListRequest implements AccuWeatherRequest {
    private String countryCode;
    private final Map<String, String> parameters;

    public AdminAreaListRequest(String countryCode, Map<String,String> options) {
        this.countryCode = countryCode;
        this.parameters = options;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public Class<? extends AccuWeatherResponse> getResponseClass() {
        return AdminAreaListResponse.class;
    }

    @Override
    public String getEndpoint() throws Exception {
        if (null == countryCode) {
            throw new Exception("Endpoint is not complete for this request");
        }
        return "locations/v1/adminareas/" + countryCode;

    }

    @Override
    public HttpMethods getHttpMethod() {
        return HttpMethods.GET;
    }

    @Override
    public Map<String, String> getParameters() {
        return this.parameters;
    }

}
