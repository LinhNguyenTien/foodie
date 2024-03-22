package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.mobile.R;
import com.example.mobile.api.ApiService;
import com.example.mobile.model.discount;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscountManagement extends AppCompatActivity {
    private ImageView ivExit, ivLocation, ivCart;
    private RecyclerView rcvDiscount;
    private List<discount> discountList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_management);
        initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDiscount.setLayoutManager(linearLayoutManager);
        getListDiscount();
    }

    private void getListDiscount() {
        ApiService.apiService.getListDiscount().enqueue(new Callback<List<discount>>() {
            @Override
            public void onResponse(Call<List<discount>> call, Response<List<discount>> response) {
                if(response.isSuccessful()) {
                    discountList = response.body();

                }
            }

            @Override
            public void onFailure(Call<List<discount>> call, Throwable t) {

            }
        });
    }

    private void initView() {
        ivExit = findViewById(R.id.ivExit);
        ivLocation = findViewById(R.id.ivLocation);
        ivCart = findViewById(R.id.ivCart);
        rcvDiscount = findViewById(R.id.rcvDiscount);
    }
}