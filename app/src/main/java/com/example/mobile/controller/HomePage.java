package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobile.R;
import com.example.mobile.adapter.adsAdapter;
import com.example.mobile.currentUser;
import com.example.mobile.model.advertisement;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomePage extends AppCompatActivity {
    private TextView tvUsername;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private adsAdapter adapter;
    private CardView menuCard, orderCard, storeCard, discountCard;
    private ImageView cart, location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initView();
        //Receive username from login activity
        if (currentUser.currentCustomer != null) {
            tvUsername.setText(currentUser.currentCustomer.getFirstName().toString() + " " + currentUser.currentCustomer.getLastName().toString());
        }

        //Slider
        adapter = new adsAdapter(this, getListAds());
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        //Set event for menuCard button
        menuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, CategoryMenu.class));
            }
        });
    }

    private List<advertisement> getListAds() {
        List<advertisement> list = new ArrayList<>();
        list.add(new advertisement(R.drawable.product01));
        list.add(new advertisement(R.drawable.product02));
        list.add(new advertisement(R.drawable.product03));
        return list;
    }

    public void initView() {
        tvUsername = findViewById(R.id.tvUsername);
        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.circle_indicator);
        menuCard = findViewById(R.id.menuCard);
        orderCard = findViewById(R.id.orderCard);
        storeCard = findViewById(R.id.storeCard);
        discountCard = findViewById(R.id.discountCard);
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, CartManagement.class);
                if(currentUser.currentCustomer == null) {
                    intent.putExtra("customerPhone", "null");
                }
                else {
                    intent.putExtra("customerPhone", currentUser.currentCustomer.getPhoneNumber());
                }
                startActivity(intent);
            }
        });
        location = findViewById(R.id.location);
    }
}