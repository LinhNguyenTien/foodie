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
import com.example.mobile.currentUser;
import com.example.mobile.model.customer;
import com.example.mobile.model.item;
import com.example.mobile.model.itemUpdate;
import com.example.mobile.model.product;
import com.example.mobile.model.review;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
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
    private ImageView ivMinus, ivPlus;
    private TextView tvQuantity;
    private String selectedProductID;
    private List<review> reviewList;
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

        reviewList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvReview.setLayoutManager(linearLayoutManager);
        getListProduct();
    }

    private void getListReview() {
        ApiService.apiService.getListReview(Integer.parseInt(selectedProduct.getProductID())).enqueue(new Callback<List<review>>() {
            @Override
            public void onResponse(Call<List<review>> call, Response<List<review>> response) {
                reviewList = response.body();
                ReviewAdapter reviewAdapter;
                if(reviewList.isEmpty()) {
                    Toast.makeText(ProductDetail.this, "Chưa có bình luận nào", Toast.LENGTH_SHORT).show();
                    reviewAdapter = new ReviewAdapter(null);
                }
                else {
                    reviewAdapter = new ReviewAdapter(reviewList);
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

    private void setInfoProduct() {
        Picasso.get().load(selectedProduct.getImageLink()).placeholder(R.drawable.loading).into(ivProduct);
        tvName.setText(selectedProduct.getProductName());
        DecimalFormat df = new DecimalFormat("#,###");
        String formattedSum = df.format(selectedProduct.getProductPrice());
        tvPrice.setText(formattedSum + "đ");
        tvDes.setText(selectedProduct.getDescription());
    }

    private void getListProduct() {
        ApiService.apiService.getProductById(Integer.parseInt(selectedProductID)).enqueue(new Callback<product>() {
            @Override
            public void onResponse(Call<product> call, Response<product> response) {
                selectedProduct = response.body();
                setInfoProduct();
                getListReview();
            }

            @Override
            public void onFailure(Call<product> call, Throwable t) {
                Toast.makeText(ProductDetail.this, "Call API Fail", Toast.LENGTH_SHORT).show();
                System.out.println("Throwable: " + t);
            }
        });
    }

    private void addItem() {
        ApiService.apiService.getListItem(currentUser.currentCustomer.getCart().getCartID())
                .enqueue(new Callback<List<item>>() {
                    @Override
                    public void onResponse(Call<List<item>> call, Response<List<item>> response) {
                        if(response.isSuccessful()) {
                            //Get all items in cart
                            List<item> itemList = response.body();
                            for(item item : itemList) {
                                //Check if the added item is existed
                                if (item.getProduct().getProductID().equals(selectedProductID)) {
                                    updateQuantityItem(item, Integer.parseInt(tvQuantity.getText().toString()));
                                    return;
                                }
                            }
                            //This means the added item is the new item
                            int quantity = Integer.parseInt(tvQuantity.getText().toString());
                            itemUpdate itemUpdate = new itemUpdate(quantity);
                            ApiService.apiService.addItem(currentUser.currentCustomer.getCart().getCartID(), selectedProductID, itemUpdate)
                                    .enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            if(response.isSuccessful()) {
                                                Toast.makeText(ProductDetail.this, "Add item success", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                System.out.print("Error code: " + response.code());
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {
                                            System.out.println("Add item fail, Throwable: " + t);
                                        }
                                    });
                        }
                        else {
                            System.out.print("Error code getListItem: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<item>> call, Throwable t) {
                        System.out.print("check item fail, throwable: " + t);
                    }
                });
    }

    private void updateQuantityItem(item item, int oldQuantity) {
        int newQuantity = Integer.parseInt(item.getQuantity()) + oldQuantity;
        System.out.print("New quantity: " + newQuantity);
        itemUpdate itemUpdate = new itemUpdate(newQuantity);
        ApiService.apiService.updateCartItemQuantity(item.getId(), itemUpdate)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()) {
                            System.out.print("Update quantity item success");
                        }
                        else {
                            System.out.print("Error code update quantity: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        System.out.print("Update quantity item fail");
                    }
                });
    }


    public void initView() {
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ivProduct = findViewById(R.id.ivProduct);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDes = findViewById(R.id.tvDes);
        rcvReview = findViewById(R.id.rcvReview);
        btnAddCart = findViewById(R.id.btnAddCart);
        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });
        btnBuyNow = findViewById(R.id.btnBuyNow);
        ivPlus = findViewById(R.id.ivPlus);
        ivPlus.setOnClickListener(v -> {
            int quantity = Integer.parseInt(tvQuantity.getText().toString());
            tvQuantity.setText(String.valueOf(quantity+1));
        });
        ivMinus = findViewById(R.id.ivMinus);
        ivMinus.setOnClickListener(v -> {
            int quantity = Integer.parseInt(tvQuantity.getText().toString());
            if(quantity > 1) {
                tvQuantity.setText(String.valueOf(quantity-1));
            }
        });
        tvQuantity = findViewById(R.id.tvQuantity);
    }
}