package com.bichi.ui;

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

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<String> s;
    private Context context;
    int index = 0;

    Adapter(List<String> s, Context context){
        this.s = s;
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
        holder.tvItem.setText(s.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = position;
                notifyDataSetChanged();
            }
        });

        if(index==position){
            holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.pressed_background));
            holder.tvItem.setTextColor(Color.WHITE);
        }
        else
        {
            holder.linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.default_background));
            holder.tvItem.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return s.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem= itemView.findViewById(R.id.txtview);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
