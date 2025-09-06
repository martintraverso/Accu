package com.martintraverso.AccuWeather.Response.Location;

import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;

import java.util.List;

public class AdminAreaListResponse implements AccuWeatherResponse {
    private List<AdminArea> AdminAreas;

    public AdminAreaListResponse(List<AdminArea> adminAreas) {
        AdminAreas = adminAreas;
    }

    public List<AdminArea> getAdminAreas() {
        return AdminAreas;
    }

    public void setAdminAreas(List<AdminArea> adminAreas) {
        AdminAreas = adminAreas;
    }
}
