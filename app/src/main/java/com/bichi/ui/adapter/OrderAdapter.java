package com.bichi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bichi.ui.R;
import com.bichi.ui.model.OrderItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private List<OrderItem> orderItems;
    private Context context;

    public OrderAdapter(List<OrderItem> orderItems, Context context){
        this.orderItems = orderItems;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View orderView = inflater.inflate(R.layout.order_item, parent, false);

        return new ViewHolder(orderView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(orderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
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
