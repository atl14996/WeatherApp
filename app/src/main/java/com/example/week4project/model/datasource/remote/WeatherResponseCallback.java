package com.example.week4project.model.datasource.remote;

import com.example.week4project.model.weather.WeatherResponse;

public interface WeatherResponseCallback {

    public void Onsuccess(WeatherResponse weatherResponse);
}
