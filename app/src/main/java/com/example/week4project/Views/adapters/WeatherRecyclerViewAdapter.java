package com.example.week4project.Views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4project.R;
import com.example.week4project.model.weather.List;
import com.example.week4project.model.weather.Weather;
import com.example.week4project.model.weather.WeatherResponse;

public class WeatherRecyclerViewAdapter extends RecyclerView.Adapter<WeatherRecyclerViewAdapter.ViewHolder> {
    java.util.List<List> resultList;


    public WeatherRecyclerViewAdapter(WeatherResponse weatherResponse) {

        this.resultList = weatherResponse.getList();
    }
    @NonNull
    @Override
    public WeatherRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRecyclerViewAdapter.ViewHolder viewHolder, int i) {
List item = resultList.get(i);
viewHolder.tvDateandTime.setText(item.getDt());
viewHolder.tvWeatherDescription.setText(item.getWeather().get(i).getDescription());
viewHolder.tvTemperature.setText(Integer.parseInt(item.getMain().getTemp().toString()));
viewHolder.tvHumidity.setText(Integer.parseInt(item.getMain().getHumidity().toString()));
        Glide.with(viewHolder.itemView.getContext()).load("http://www.openweathermap.org/img/w/"+ item.getWeather().get(i).getIcon() + ".png").into(viewHolder.imgIconView);
        viewHolder.tvWindSpeed.setText(Integer.parseInt(item.getWind().getSpeed().toString()));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTemperature;
        TextView tvWeatherDescription;
        ImageView imgIconView;
        TextView tvHumidity;
        TextView tvDateandTime;
        TextView tvWindSpeed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDateandTime = itemView.findViewById(R.id.tvDateAndTime);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);
            imgIconView = itemView.findViewById(R.id.imgIcon);
            tvWeatherDescription = itemView.findViewById(R.id.tvDescription);
            tvHumidity = itemView.findViewById(R.id.tvhumidity);
            tvWindSpeed = itemView.findViewById(R.id.tvWindSpeed);
        }
    }
}
