package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.mobile.R;
import com.example.mobile.adapter.categoryAdapter;
import com.example.mobile.api.ApiService;
import com.example.mobile.model.category;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryMenu extends AppCompatActivity {
    private ImageView ivExit, ivLocation, ivCart;
    private RecyclerView rcv_category;
    private List<category> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        initView();

        categoryList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv_category.setLayoutManager(gridLayoutManager);
        getListCategory();
    }
    public void initView() {
        ivExit = findViewById(R.id.ivExit);
        ivExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryMenu.this, HomePage.class));
            }
        });
        ivLocation = findViewById(R.id.ivLocation);
        ivCart = findViewById(R.id.ivCart);
        rcv_category = findViewById(R.id.rcvCategory);
    }

    private void getListCategory() {
        ApiService.apiService.getListCategory().enqueue(new Callback<List<category>>() {
            @Override
            public void onResponse(Call<List<category>> call, Response<List<category>> response) {
                categoryList = response.body();
                categoryAdapter categoryAdapter = new categoryAdapter(categoryList);
                rcv_category.setAdapter(categoryAdapter);
            }

            @Override
            public void onFailure(Call<List<category>> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(CategoryMenu.this, "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}