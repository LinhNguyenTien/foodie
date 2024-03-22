package com.example.mobile.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile.R;
import com.example.mobile.api.ApiService;
import com.example.mobile.controller.ProductDetail;
import com.example.mobile.controller.ProductMenu;
import com.example.mobile.currentUser;
import com.example.mobile.model.item;
import com.example.mobile.model.itemUpdate;
import com.example.mobile.model.product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class productAdapter extends RecyclerView.Adapter<productAdapter.productViewHolder>{
    private final List<product> productList;

    public productAdapter(List<product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new productViewHolder(view, productList);
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {
        product product = productList.get(position);
        if(product == null) {
            return;
        }
        holder.tvName.setText(product.getProductName());
        DecimalFormat df = new DecimalFormat("#,###");
        String formattedSum = df.format(product.getProductPrice());
        holder.tvPrice.setText(formattedSum + "đ");
        Picasso.get().load(product.getImageLink()).placeholder(R.drawable.loading).into(holder.ivProduct);
        holder.btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService.apiService.getListItem(currentUser.currentCustomer.getCart().getCartID())
                        .enqueue(new Callback<List<item>>() {
                            @Override
                            public void onResponse(Call<List<item>> call, Response<List<item>> response) {
                                if(response.isSuccessful()) {
                                    //Get all items in cart
                                    List<item> itemList = response.body();
                                    for(item item : itemList) {
                                        //Check if the added item is existed
                                        if (item.getProduct().getProductID().equals(product.getProductID())) {
                                            updateQuantityItem(item, 1);
                                            return;
                                        }
                                    }
                                    //This means the added item is the new item
                                    itemUpdate itemUpdate = new itemUpdate(1);
                                    ApiService.apiService.addItem(currentUser.currentCustomer.getCart().getCartID(), product.getProductID(), itemUpdate)
                                            .enqueue(new Callback<Void>() {
                                                @Override
                                                public void onResponse(Call<Void> call, Response<Void> response) {
                                                    if(response.isSuccessful()) {
                                                        System.out.print("Add item success");
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

    @Override
    public int getItemCount() {
        if(productList != null){
            return productList.size();
        }
        return 0;
    }

    public class productViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvPrice;
        private ImageView ivProduct;
        private Button btnBuyNow;
        private List<product> productList;

        public productViewHolder(@NonNull View itemView, List<product> productList) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            btnBuyNow = itemView.findViewById(R.id.btnBuyNow);
            this.productList = productList;

            ivProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String productID = getProductFromView(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), ProductDetail.class);
                    intent.putExtra("product_id", productID);
                    itemView.getContext().startActivity(intent);
                }
            });
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String categoryId = getProductFromView(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), ProductDetail.class);
                    intent.putExtra("product_id", categoryId);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        private String getProductFromView(int adapterPosition) {
            return productList.get(adapterPosition).getProductID();
        }
    }
}
