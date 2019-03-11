package com.example.week4project.Views.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.week4project.R;
import com.example.week4project.Views.adapters.WeatherRecyclerViewAdapter;
import com.example.week4project.model.datasource.remote.WeatherResponseCallback;
import com.example.week4project.model.datasource.remote.WeatherResponseRepository;
import com.example.week4project.model.weather.Weather;
import com.example.week4project.model.weather.WeatherResponse;

public class SecondActivity extends AppCompatActivity implements WeatherResponseCallback {
    RecyclerView rvWeatherList;
    Intent passedIntent;
    String zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        passedIntent = getIntent();
        zipCode = passedIntent.getStringExtra("zip_code");
        WeatherResponseRepository weatherResponseRepository = new WeatherResponseRepository();
        weatherResponseRepository.getWeatherResponse(zipCode + ",us", "dbf50b3237f9aa12027194b2d6e80dda", "imperial",this);
    }

    @Override
    public void Onsuccess(WeatherResponse weatherResponse) {

        initializeRecyclerView(weatherResponse);

    }

    private void initializeRecyclerView(WeatherResponse weatherResponse) {
rvWeatherList = findViewById(R.id.RVWeatherOutput);
rvWeatherList.setLayoutManager(new LinearLayoutManager(this));
rvWeatherList.setAdapter(new WeatherRecyclerViewAdapter(weatherResponse));
    }


}
