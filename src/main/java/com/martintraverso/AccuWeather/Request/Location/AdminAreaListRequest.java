package com.martintraverso.AccuWeather.Request.Location;

import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;
import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;
import com.martintraverso.AccuWeather.Response.Location.AdminAreaListResponse;
import com.martintraverso.AccuWeather.Utilities.HttpMethods;

public class AdminAreaListRequest implements AccuWeatherRequest {
    private String countryCode;

    public AdminAreaListRequest(String countryCode) {
        this.countryCode = countryCode;
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
}
