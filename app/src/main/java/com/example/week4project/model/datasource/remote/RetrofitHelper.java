package com.example.week4project.model.datasource.remote;

import com.example.week4project.model.weather.WeatherResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4project.model.datasource.remote.APIConstants.BASE_URL;
import static com.example.week4project.model.datasource.remote.APIConstants.PATH_API;
import static com.example.week4project.model.datasource.remote.APIConstants.QUERY_API_KEY;
import static com.example.week4project.model.datasource.remote.APIConstants.QUERY_API_ZIP_CODE;
import static com.example.week4project.model.datasource.remote.APIConstants.QUERY_UNITS;

public class RetrofitHelper {

    private static OkHttpClient getOkHttpClientWithInterceptor(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

    }

    private static Retrofit getRetrofit() {

        return new Retrofit.Builder().baseUrl(BASE_URL).
                client(getOkHttpClientWithInterceptor()).
                addConverterFactory(GsonConverterFactory.
                        create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.
                        create()).build();

    }


    private ObservableInterface getWeatherResponseInterface() {


        return getRetrofit().create(ObservableInterface.class);
    }


    public Observable<WeatherResponse> getWeatherResponseObservable(String zipCode, String apiKey, String units) {

        return getWeatherResponseInterface().getWeatherResponseObservable(zipCode, apiKey, units);

    }


    public interface ObservableInterface{

        @GET(PATH_API)
        Observable<WeatherResponse> getWeatherResponseObservable(@Query(QUERY_API_ZIP_CODE) String zipCode, @Query(QUERY_API_KEY) String apiKey,
                                                                 @Query(QUERY_UNITS) String units);

    }
}




