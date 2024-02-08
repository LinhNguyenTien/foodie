package com.example.mobile.api;

import com.example.mobile.model.category;
import com.example.mobile.model.customer;
import com.example.mobile.model.product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    public static final String BASE_URL = "http://10.0.2.2:3000/";
    ApiService apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    //access to endpoint: http://localhost:3000/customers
    @GET("customers")
    Call<List<customer>> getListUser();

    @GET("products")
    Call<List<product>> getListProduct();

    @GET("categories")
    Call<List<category>> getListCategory();

    @POST("customers")
    Call<customer> createNewAccount(@Body customer customer);
}
