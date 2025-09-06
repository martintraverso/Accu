package com.martintraverso.AccuWeather.Response.Location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.martintraverso.AccuWeather.Response.AccuWeatherResponse;

public class AdminArea implements AccuWeatherResponse {
    private String ID;
    private String LocalizedName;
    private String EnglishName;
    private int Level;
    private String LocalizedType;
    private String EnglishType;
    private String CountryID;

    @JsonCreator
    public AdminArea(@JsonProperty("ID") String ID,
                     @JsonProperty("LocalizedName") String localizedName,
                     @JsonProperty("EnglishName") String EnglishName,
                     @JsonProperty("Level") int Level,
                     @JsonProperty("LocalizedType") String LocalizedType,
                     @JsonProperty("EnglishType") String EnglishType,
                     @JsonProperty("CountryID") String CountryID) {
        this.ID = ID;
        this.LocalizedName = localizedName;
        this.EnglishName = EnglishName;
        this.Level = Level;
        this.LocalizedType = LocalizedType;
        this.EnglishType = EnglishType;
        this.CountryID = CountryID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public void setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getLocalizedType() {
        return LocalizedType;
    }

    public void setLocalizedType(String localizedType) {
        LocalizedType = localizedType;
    }

    public String getEnglishType() {
        return EnglishType;
    }

    public void setEnglishType(String englishType) {
        EnglishType = englishType;
    }

    public String getCountryID() {
        return CountryID;
    }

    public void setCountryID(String countryID) {
        CountryID = countryID;
    }
}
