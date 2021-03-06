package com.bichi.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bichi.ui.R;
import com.bichi.ui.model.HorizontalItem;

import java.util.List;

public class ItemStatusAdapter extends RecyclerView.Adapter<ItemStatusAdapter.ViewHolder>{

    private List<HorizontalItem> items;
    private Context context;
    int selectedIndex = 0;

    public ItemStatusAdapter(List<HorizontalItem> items, Context context){
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvItem.setText(items.get(position).getItem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedIndex = position;
                notifyDataSetChanged();
            }
        });

        if(selectedIndex==position){
            holder.tvItem.setBackground(ContextCompat.getDrawable(context, R.drawable.pressed_background));
            holder.tvItem.setTextColor(Color.WHITE);
        }
        else
        {
            holder.tvItem.setBackground(ContextCompat.getDrawable(context, R.drawable.default_background));
            holder.tvItem.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem= itemView.findViewById(R.id.txtview);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
