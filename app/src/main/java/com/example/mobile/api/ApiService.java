package com.example.mobile.api;

import com.example.mobile.model.cart;
import com.example.mobile.model.category;
import com.example.mobile.model.customer;
import com.example.mobile.model.item;
import com.example.mobile.model.itemUpdate;
import com.example.mobile.model.product;
import com.example.mobile.model.review;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //public link: https://0a37-14-241-183-210.ngrok-free.app/api/
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
    @GET("reviews")
    Call<List<review>> getListReview();
    @GET("products")
    Call<List<product>> getProductById(@Query("productID") String productId);
    @GET("items")
    Call<List<item>> getItemByCustomerPhone(@Query("phone") String phoneNumber);
    @GET("carts")
    Call<List<cart>> getCardID(@Query("phoneNumber") String phoneNumber);
    @GET("items")
    Call<List<item>> getListItem(@Query("cartID") String cartID, @Query("orderID") String orderID);

    @POST("customers")
    Call<customer> createNewAccount(@Body customer customer);

    @PATCH("items/{id}")
    Call<Void> updateCartItemQuantity(@Path("id") String id, @Body itemUpdate item);

    @DELETE("items/{id}")
    Call<Void> deleteItemFromCart(@Path("id") String id);
}
