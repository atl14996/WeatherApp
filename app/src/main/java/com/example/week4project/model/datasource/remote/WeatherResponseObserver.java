package com.example.week4project.model.datasource.remote;

import android.util.Log;

import com.example.week4project.model.weather.WeatherResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WeatherResponseObserver  implements Observer<WeatherResponse> {
   WeatherResponse returnWeatherResponse;
   WeatherResponseCallback weatherResponseCallback;

    public WeatherResponseObserver(WeatherResponseCallback weatherResponseCallback) {
        this.weatherResponseCallback = weatherResponseCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d("TAG", "onSubscribe: ");

    }

    @Override
    public void onNext(WeatherResponse weatherResponse) {

        returnWeatherResponse = weatherResponse;
        Log.d("TAG", "onNext: what's wrong");
    }

    @Override
    public void onError(Throwable e) {

        Log.d("TAG", "onError: ");

    }

    @Override
    public void onComplete() {

        weatherResponseCallback.Onsuccess(returnWeatherResponse);
        Log.d("TAG", "onComplete: oncomplete success");

    }
}
