package com.example.week4project.model.datasource.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherResponseRepository {
    private RetrofitHelper retrofitHelper;


    public WeatherResponseRepository() {

        this.retrofitHelper = new RetrofitHelper();

    }

    public void getWeatherResponse(String zipCode, String apiKey, String units, WeatherResponseCallback weatherResponseCallback) {

        retrofitHelper.getWeatherResponseObservable(zipCode,apiKey,units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WeatherResponseObserver(weatherResponseCallback));


    }

}
