package com.bichi.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private List<OrderItem> items;
    private Context context;
    int index = 0;
    OrderAdapter(List<OrderItem> items, Context context){
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.order_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView orderId,date,price,orderStatus,new_item;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.order);
            date = itemView.findViewById(R.id.date);
            price = itemView.findViewById(R.id.price);
            orderStatus = itemView.findViewById(R.id.order_status);
            imageView = itemView.findViewById(R.id.image);
            new_item = itemView.findViewById(R.id.new_item);
        }

        void bind(OrderItem orderItem){
            orderId.setText(orderItem.getOrderNumber());
            date.setText(orderItem.getDate());
            price.setText("₹"+orderItem.getPrice());
            orderStatus.setText(orderItem.getStatus());
            Glide.with(context)
                    .load(orderItem.getImage())
                    .into(imageView);

            if(orderItem.isNew()){
                new_item.setVisibility(View.VISIBLE);
            }else {
                new_item.setVisibility(View.GONE);
            }
        }
    }
}
