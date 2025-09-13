package com.martintraverso.AccuWeather.Response.Location;

import com.martintraverso.AccuWeather.Entity.AccuWeatherEntity;
import com.martintraverso.AccuWeather.Entity.AdminArea;
import com.martintraverso.AccuWeather.Response.AccuWeatherSuccessResponse;

import java.util.ArrayList;
import java.util.List;

public class AdminAreaListResponse implements AccuWeatherSuccessResponse {
    private List<AccuWeatherEntity> AdminAreas = new ArrayList<>();

    public AdminAreaListResponse() {}

    public List<AccuWeatherEntity> getResponse() {
        return AdminAreas;
    }

    public void setAdminAreas(List<AccuWeatherEntity> adminAreas) {
        AdminAreas = adminAreas;
    }

    public void add(AdminArea adminArea) {
        this.AdminAreas.add(adminArea);
    }
}
