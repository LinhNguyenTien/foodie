package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile.R;
import com.example.mobile.adapter.orderDetailAdapter;
import com.example.mobile.api.ApiService;
import com.example.mobile.currentUser;
import com.example.mobile.model.item;
import com.example.mobile.model.receivedOrder;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetail extends AppCompatActivity {
    private TextView tvOrderCode, tvOrderTime, tvOrderTotal, tvSum, tvTotal, tvPayment, tvDiscount, tvAddress;
    private RecyclerView rcvItem;
    private ImageView ivExit;
    private List<item> itemList;
    private receivedOrder selectedOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        String orderID = getIntent().getStringExtra("orderID");
        String orderStatusID = getIntent().getStringExtra("orderStatusID");
        initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvItem.setLayoutManager(linearLayoutManager);
        getListItem(Integer.parseInt(orderID), Integer.parseInt(orderStatusID));
    }

    private void getListItem(int orderID, int orderStatusID) {
        ApiService.apiService.getListOrder(Integer.parseInt(currentUser.currentCustomer.getId()), orderStatusID).enqueue(new Callback<List<receivedOrder>>() {
            @Override
            public void onResponse(Call<List<receivedOrder>> call, Response<List<receivedOrder>> response) {
                if (response.isSuccessful()) {
                    List<receivedOrder> orderList = response.body();
                    for (receivedOrder order : orderList) {
                        System.out.println("Received order: " + order.getId() + ", Selected order: " + orderID);
                        if (order.getId() == orderID) {
                            selectedOrder = order;
                        }
                    }
                    tvOrderCode.setText("Mã đơn: #" + selectedOrder.getId());
                    tvOrderTime.setText("Ngày mua hàng: " + selectedOrder.getOrderdate());
                    DecimalFormat df = new DecimalFormat("#,###");
                    String formattedTotal = df.format(Double.parseDouble(selectedOrder.getTotalprice()) + 10000);
                    tvOrderTotal.setText("Tổng hóa đơn: " + formattedTotal + "đ");
                    String formattedSum = df.format(Double.parseDouble(selectedOrder.getTotalprice()));
                    tvSum.setText(formattedSum + "đ");
                    tvTotal.setText(formattedTotal + "đ");
                    tvDiscount.setText("0đ");
                    tvPayment.setText(selectedOrder.getCheckout().getMethod());
                    tvAddress.setText("Giao đến: " + selectedOrder.getAccount().getAddress().getAddressDetail());
                    orderDetailAdapter orderDetailAdapter = new orderDetailAdapter(selectedOrder.getItems());
                    rcvItem.setAdapter(orderDetailAdapter);
                }
                else {
                    System.out.print("Error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<receivedOrder>> call, Throwable t) {
                System.out.print("Throwable: " + t);
            }
        });
    }

    private void initView() {
        tvOrderCode = findViewById(R.id.tvOrderCode);
        tvOrderTime = findViewById(R.id.tvOrderTime);
        tvOrderTotal = findViewById(R.id.tvOrderTotal);
        tvSum = findViewById(R.id.tvSum);
        tvTotal = findViewById(R.id.tvTotalBill);
        tvDiscount = findViewById(R.id.tvDiscount);
        tvPayment = findViewById(R.id.tvPayment);
        tvAddress = findViewById(R.id.tvAddress);
        ivExit = findViewById(R.id.ivExit);
        ivExit.setOnClickListener(v -> {
            finish();
        });
        rcvItem = findViewById(R.id.rcvItem);
    }
}