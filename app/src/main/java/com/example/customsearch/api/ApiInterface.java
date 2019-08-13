package com.example.customsearch.api;

import com.example.customsearch.model.SearchResults;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/customsearch/v1")
    Call<SearchResults> getSearchResults(@Query("q") String query, @Query("cx") String cx, @Query("key") String key, @Query("start") int startIndex);
}
