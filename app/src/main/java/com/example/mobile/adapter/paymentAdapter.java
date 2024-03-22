package com.example.mobile.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.mobile.api.ApiService;
import com.example.mobile.controller.PaymentInformation;
import com.example.mobile.currentUser;
import com.example.mobile.model.item;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class paymentAdapter extends itemAdapter{

    public paymentAdapter(List<item> itemList, TextView tvSum) {
        super(itemList, tvSum);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService.apiService.deleteItemFromCart(holder.item.getId())
                        .enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Toast.makeText(view.getContext(), "Delete item success", Toast.LENGTH_SHORT).show();
                                recalculateSum();
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(view.getContext(), "Delete item fail", Toast.LENGTH_SHORT).show();
                            }
                        });

                itemList.remove(holder.getAdapterPosition());
                if(itemList.size()==0) {
                    PaymentInformation.paymentInformationActivity.finish();
                }
                // Notify the adapter about the removal
                notifyItemRemoved(holder.getAdapterPosition());
                // Update other items' positions
                notifyItemRangeChanged(holder.getAdapterPosition(), itemList.size());
            }
        });
    }
}
