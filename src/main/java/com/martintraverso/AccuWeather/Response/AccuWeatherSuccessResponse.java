package com.martintraverso.AccuWeather.Response;

import com.martintraverso.AccuWeather.Entity.AccuWeatherEntity;

import java.util.List;

public interface AccuWeatherSuccessResponse extends AccuWeatherResponse{
    public List<AccuWeatherEntity> getResponse();
}
