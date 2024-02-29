package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile.R;
import com.example.mobile.adapter.ReviewAdapter;
import com.example.mobile.adapter.itemAdapter;
import com.example.mobile.api.ApiService;
import com.example.mobile.model.cart;
import com.example.mobile.model.item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartManagement extends AppCompatActivity {
    private RecyclerView rcvItem;
    private Button btnAddProduct;
    private Button btnPayment;
    private TextView tvSum;
    private ImageView ivExit;
    private List<item> itemList;
    private cart cart;
    private float sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_cart);

        initView();
        String customerPhone = getIntent().getStringExtra("customerPhone");
        //If the user signed in customerPhone will contain the string value of phone number
        if(customerPhone != null) {
            itemList = new ArrayList<>();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rcvItem.setLayoutManager(linearLayoutManager);
            getListItems(customerPhone);
        }
        //else there is no string value and set an empty itemAdapter for rcvItem
        else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rcvItem.setLayoutManager(linearLayoutManager);
            itemAdapter itemAdapter = new itemAdapter(null, tvSum);
            rcvItem.setAdapter(itemAdapter);
        }
    }

    private void getListItems(String customerPhone) {
        ApiService.apiService.getCardID(customerPhone).enqueue(new Callback<List<cart>>() {
            @Override
            public void onResponse(Call<List<cart>> call, Response<List<cart>> response) {
                if(response.isSuccessful()){
                    //get the first element of array carts
                    cart = response.body().get(0);
                    ApiService.apiService.getListItem(cart.getCartID(), "-1").enqueue(new Callback<List<item>>() {
                        @Override
                        public void onResponse(Call<List<item>> call, Response<List<item>> response) {
                            itemList = response.body();
                            for (item item : itemList){
                                 sum += Double.parseDouble(item.getPrice())*Integer.parseInt(item.getQuantity());
                            }
                            tvSum.setText(String.valueOf(sum) + " VNĐ");
                            itemAdapter itemAdapter = new itemAdapter(itemList, tvSum);
                            rcvItem.setAdapter(itemAdapter);
                        }

                        @Override
                        public void onFailure(Call<List<item>> call, Throwable t) {
                            Toast.makeText(CartManagement.this, "Connection fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<cart>> call, Throwable t) {
                cart = null;
                Toast.makeText(CartManagement.this, "Get cartID fail", Toast.LENGTH_SHORT).show();
                System.out.println(t);
            }
        });
    }

    public void initView() {
        rcvItem = findViewById(R.id.rcvItem);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartManagement.this, CategoryMenu.class);
                startActivity(intent);
            }
        });
        btnPayment = findViewById(R.id.btnPayment);
        tvSum = findViewById(R.id.tvSum);
        ivExit = findViewById(R.id.ivExit);
        ivExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartManagement.this, HomePage.class));
            }
        });
    }
}