package com.example.mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile.R;
import com.example.mobile.api.ApiService;
import com.example.mobile.currentUser;
import com.example.mobile.model.cart;
import com.example.mobile.model.item;
import com.example.mobile.model.itemUpdate;
import com.example.mobile.model.product;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemViewHolder> {
    private final List<item> itemList;
    private TextView tvSum;
    public itemAdapter(List<item> itemList, TextView tvSum) {
        this.itemList = itemList;
        this.tvSum = tvSum;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new itemAdapter.itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        holder.item = itemList.get(position);
        if(holder.item == null) {
            return;
        }

        //Call API to get the information of product
        ApiService.apiService.getProductById(holder.item.getProductID()).enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                holder.product = response.body().get(0);
                holder.tvName.setText(holder.product.getProductName());
                DecimalFormat df = new DecimalFormat("#,###");
                float price = holder.product.getProductPrice();
                String formattedPrice = df.format(price);
                holder.tvPrice.setText(String.valueOf(formattedPrice) + " đ");
            }

            @Override
            public void onFailure(Call<List<product>> call, Throwable t) {
                System.out.println("Call fail");
            }
        });
        //Set the name and price of the product on the view
        holder.tvQuantity.setText(holder.item.getQuantity());
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQuantity = Integer.parseInt(holder.tvQuantity.getText().toString());
                currentQuantity++;
                holder.tvQuantity.setText(String.valueOf(currentQuantity));
                updateCurrentQuantity(currentQuantity, holder);
                recalculateSum();
            }
        });

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked on minus btn");
                int currentQuantity = Integer.parseInt(holder.tvQuantity.getText().toString());
                if(currentQuantity > 1) currentQuantity--;
                else {
                    holder.btnRemove.setEnabled(false);
                }

                holder.tvQuantity.setText(String.valueOf(currentQuantity));
                updateCurrentQuantity(currentQuantity, holder);
                recalculateSum();
            }
        });

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
                // Notify the adapter about the removal
                notifyItemRemoved(holder.getAdapterPosition());
                // Update other items' positions
                notifyItemRangeChanged(holder.getAdapterPosition(), itemList.size());
            }
        });
    }

    private void recalculateSum() {
        ApiService.apiService.getCardID(currentUser.currentCustomer.getPhoneNumber()).enqueue(new Callback<List<cart>>() {
            @Override
            public void onResponse(Call<List<cart>> call, Response<List<cart>> response) {
                cart cart = response.body().get(0);
                ApiService.apiService.getListItem(cart.getCartID(), "-1").enqueue(new Callback<List<item>>() {
                    @Override
                    public void onResponse(Call<List<item>> call, Response<List<item>> response) {
                        List<item> items = response.body();
                        float sum = 0;
                        for (item item : items) {
                            sum += Double.parseDouble(item.getPrice())*Integer.parseInt(item.getQuantity());
                        }
                        DecimalFormat df = new DecimalFormat("#,###");
                        String formattedSum = df.format(sum);
                        tvSum.setText(String.valueOf(formattedSum) + " đ");
                        System.out.println("Recalculate sum success, new sum = " + sum);
                    }

                    @Override
                    public void onFailure(Call<List<item>> call, Throwable t) {
                        System.out.println("Recalculate sum error: " + t);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<cart>> call, Throwable t) {
                System.out.println("Error: " + t);
            }
        });
    }

    private void updateCurrentQuantity(int currentQuantity, itemViewHolder holder) {
        itemUpdate item = new itemUpdate(currentQuantity);
        System.out.println(holder.item.getId());
        ApiService.apiService.updateCartItemQuantity(holder.item.getId(), item)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()) {
                            //Do nothing
                            System.out.println("Increase quantity product successfully");
                        }
                        else {
                            System.out.println("Error code: " + response.code());
                        }
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        //Do nothing
                        System.out.println("Increase quantity product fail by " + t);
                    }
                });
    }

    @Override
    public int getItemCount() {
        if(itemList != null){
            return itemList.size();
        }
        return 0;
    }

    public class itemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPrice;
        private ImageView btnAdd, btnRemove, btnDelete;
        private TextView tvQuantity;
        private item item;
        private product product;
        private RelativeLayout relativeLayout;
        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnAdd = itemView.findViewById(R.id.ivAdd);
            btnRemove = itemView.findViewById(R.id.ivRemove);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            relativeLayout = itemView.findViewById(R.id.layoutCartManager);

        }
    }
}
