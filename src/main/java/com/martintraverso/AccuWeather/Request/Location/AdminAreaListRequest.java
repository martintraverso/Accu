package com.martintraverso.AccuWeather.Request.Location;

import com.fasterxml.jackson.databind.JsonNode;
import com.martintraverso.AccuWeather.Entity.AdminArea;
import com.martintraverso.AccuWeather.Request.AccuWeatherRequest;
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
    public AdminAreaListResponse buildFromJson(JsonNode node) {
        AdminAreaListResponse response = new AdminAreaListResponse();
        for(var i =0; i < node.size(); i++) {
            AdminArea adminArea = new AdminArea(node.get(i));
            response.add(adminArea);
        }
        return response;
    }

    @Override
    public String getEndpoint() throws Exception {
        if (null == countryCode) {
            return "locations/v1/adminareas";
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
