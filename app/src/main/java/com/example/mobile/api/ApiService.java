package com.example.mobile.api;

import com.example.mobile.model.account;
import com.example.mobile.model.cart;
import com.example.mobile.model.category;
import com.example.mobile.model.customer;
import com.example.mobile.model.discount;
import com.example.mobile.model.item;
import com.example.mobile.model.itemUpdate;
import com.example.mobile.model.order;
import com.example.mobile.model.product;
import com.example.mobile.model.receivedOrder;
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
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //public link: https://0a37-14-241-183-210.ngrok-free.app/api/
    public static final String BASE_URL = "http://192.168.56.1:8080/api/";
    ApiService apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    //access to endpoint: http://localhost:3000/customers
    @GET("customers")
    Call<List<customer>> getListUser();

    @GET("product/category/{idCate}")
    Call<List<product>> getListProduct(@Path("idCate") int idCate);

    @GET("category/")
    Call<List<category>> getListCategory();
    @GET("review/product/{idProduct}")
    Call<List<review>> getListReview(@Path("idProduct") int idProduct);
    @GET("product/{id}")
    Call<product> getProductById(@Path("id") int id);
    @GET("cart/current/{idCart}")
    Call<List<item>> getListItem(@Path("idCart") String cartID);
    @GET("order/toporder")
    Call<List<product>> getBestSellers();
    @GET("discount/current")
    Call<List<discount>> getListDiscount();

    @GET("order/{accountID}/{orderStatusId}?sort=desc")
    Call<List<receivedOrder>> getListOrder(@Path("accountID") int accountID, @Path("orderStatusId") int orderStatusId);

    @POST("login/")
    Call<customer> login(@Body account account);
    @POST("customers")
    Call<customer> createNewAccount(@Body customer customer);
    @POST("item/add/{cartID}/{productID}")
    Call<Void> addItem(@Path("cartID") String cardID, @Path("productID") String productID, @Body itemUpdate item);
    @POST("order/add/{accountID}/{checkoutID}")
    Call<Void> addOrder(@Path("accountID") String accountID, @Path("checkoutID") String checkoutID, @Body order order);
    @PUT("item/{id}")
    Call<Void> updateCartItemQuantity(@Path("id") String id, @Body itemUpdate item);
    @PUT("account/{id}")
    Call<Void> updateProfile(@Path("id") String id, @Body customer customer);

    @DELETE("item/{id}")
    Call<Void> deleteItemFromCart(@Path("id") String id);
}
