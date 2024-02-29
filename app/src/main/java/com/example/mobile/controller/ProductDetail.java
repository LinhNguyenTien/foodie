package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile.R;
import com.example.mobile.adapter.ReviewAdapter;
import com.example.mobile.adapter.productAdapter;
import com.example.mobile.api.ApiService;
import com.example.mobile.model.customer;
import com.example.mobile.model.product;
import com.example.mobile.model.review;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetail extends AppCompatActivity {
    private ImageView ivBack, ivProduct;
    private TextView tvName, tvPrice, tvDes;
    private RecyclerView rcvReview;
    private Button btnAddCart, btnBuyNow;
    private String selectedProductID;
    private List<product> productList;
    private List<review> reviewList;
    private List<customer> customerList;
    private product selectedProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        selectedProductID = getIntent().getStringExtra("product_id");
        if (selectedProductID == null) {
            Toast.makeText(this, "get Product string fail", Toast.LENGTH_SHORT).show();
        }
        initView();

        productList = new ArrayList<>();
        reviewList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvReview.setLayoutManager(linearLayoutManager);
        getListProduct();
        getListReview();
    }

    private void getListReview() {
        getListUser();
        ApiService.apiService.getListReview().enqueue(new Callback<List<review>>() {
            @Override
            public void onResponse(Call<List<review>> call, Response<List<review>> response) {
                List<review> list = response.body();
                for(review review : list) {
                    if(review.getProductID().equals(selectedProductID)) {
                        reviewList.add(review);
                    }
                }
                ReviewAdapter reviewAdapter;
                if(reviewList.isEmpty()) {
                    Toast.makeText(ProductDetail.this, "Chưa có bình luận nào", Toast.LENGTH_SHORT).show();
                    reviewAdapter = new ReviewAdapter(null, customerList);
                }
                else {
                    reviewAdapter = new ReviewAdapter(reviewList, customerList);
                    reviewAdapter.notifyDataSetChanged();
                }
                rcvReview.setAdapter(reviewAdapter);

            }

            @Override
            public void onFailure(Call<List<review>> call, Throwable t) {
                Toast.makeText(ProductDetail.this, "Call api fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getListUser() {
        ApiService.apiService.getListUser()
                .enqueue(new Callback<List<customer>>() {
                    @Override
                    public void onResponse(Call<List<customer>> call, Response<List<customer>> response) {
                        customerList = response.body();
                    }

                    @Override
                    public void onFailure(Call<List<customer>> call, Throwable t) {
                        Toast.makeText(ProductDetail.this, "Call API Failed", Toast.LENGTH_SHORT).show();
                        Log.e("MainActivity", t.getMessage());
                    }
                });
    }

    private void setInfoProduct() {
        Picasso.get().load(selectedProduct.getImageLink()).placeholder(R.drawable.loading).into(ivProduct);
        tvName.setText(selectedProduct.getProductName());
        tvPrice.setText(String.valueOf((int) selectedProduct.getProductPrice()) + "VNĐ");
        tvDes.setText(selectedProduct.getDiscription());
    }

    private void getListProduct() {
        ApiService.apiService.getListProduct().enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                productList = response.body();
                for (product product : productList) {
                    if(product.getProductID().compareTo(selectedProductID) == 0) {
                        selectedProduct = product;
                        setInfoProduct();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {
                Toast.makeText(ProductDetail.this, "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initView() {
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cateID = selectedProduct.getCategoryID();
                Intent intent = new Intent(ProductDetail.this, ProductMenu.class);
                intent.putExtra("category_id", cateID);
                startActivity(intent);
            }
        });
        ivProduct = findViewById(R.id.ivProduct);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDes = findViewById(R.id.tvDes);
        rcvReview = findViewById(R.id.rcvReview);
        btnAddCart = findViewById(R.id.btnAddCart);
        btnBuyNow = findViewById(R.id.btnBuyNow);
    }
}