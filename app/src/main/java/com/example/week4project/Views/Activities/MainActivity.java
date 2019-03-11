package com.example.week4project.Views.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.week4project.R;

public class MainActivity extends AppCompatActivity {
    EditText enterZIP;
    Button btnSubmitforWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterZIP = findViewById(R.id.etEnterZIP);
        btnSubmitforWeather = findViewById(R.id.btnSumbitforWeatherInfo);
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("zip_code", enterZIP.getText().toString());
        startActivity(intent);
    }
}
