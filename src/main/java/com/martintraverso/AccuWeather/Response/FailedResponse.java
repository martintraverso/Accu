package com.martintraverso.AccuWeather.Response;

public class FailedResponse implements AccuWeatherFailedResponse {
    private String message;
    private int code;

    public FailedResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
