package com.example.customsearch.api;

import com.example.customsearch.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    private static final int TimeOut = 20;

    private static String BASE_URL = "https://www.googleapis.com";

    private static OkHttpClient.Builder getHttClientBuilder() {
        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor1 = new HttpLoggingInterceptor();
            interceptor1.setLevel(HttpLoggingInterceptor.Level.BODY);
            return new OkHttpClient.Builder().addInterceptor(interceptor1);
        } else
            return new OkHttpClient.Builder();
    }

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient.Builder okHttpClient = getHttClientBuilder()
                .connectTimeout(TimeOut, TimeUnit.SECONDS)
                .writeTimeout(TimeOut, TimeUnit.SECONDS)
                .readTimeout(TimeOut, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient.build())
                .build();
    }
}
