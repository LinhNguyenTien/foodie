package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.mobile.R;
import com.example.mobile.adapter.productAdapter;
import com.example.mobile.api.ApiService;
import com.example.mobile.model.product;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductMenu extends AppCompatActivity {
    private ImageView ivExit, ivLocation, ivCart;
    private RecyclerView rcvProduct;
    private String selectedCategoryID;
    private List<product> productList, productByCateList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_menu);

        selectedCategoryID = getIntent().getStringExtra("category_id");
        if (selectedCategoryID == null) {
            Toast.makeText(this, "get Cate string fail", Toast.LENGTH_SHORT).show();
        }
        initView();

        productList = new ArrayList<>();
        productByCateList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvProduct.setLayoutManager(linearLayoutManager);
        getListProduct();
    }
    public void initView() {
        ivExit = findViewById(R.id.ivExit);
        ivExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductMenu.this, CategoryMenu.class));
            }
        });
        ivLocation = findViewById(R.id.ivLocation);
        ivCart = findViewById(R.id.ivCart);
        rcvProduct = findViewById(R.id.rcvCategory);
    }

    private void getListProduct() {
        ApiService.apiService.getListProduct().enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                productList = response.body();
                for (product product : productList) {
                    if(product.getCategoryID().compareTo(selectedCategoryID) == 0) {
                        productByCateList.add(product);
                    }
                }
                productAdapter productAdapter = new productAdapter(productByCateList);
                rcvProduct.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {
                Toast.makeText(ProductMenu.this, "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}