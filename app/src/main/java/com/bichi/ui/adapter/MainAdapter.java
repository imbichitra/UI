package com.bichi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bichi.ui.R;
import com.bichi.ui.model.HorizontalItem;
import com.bichi.ui.model.MainData;
import com.bichi.ui.model.OrderItem;
import com.bichi.ui.view.HomeFragment;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> items;
    private  final int MAIN =1;
    private  final int HORIZONTAL =2;
    private  final int VERTICAL =3;

    public MainAdapter(Context context,ArrayList<Object> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType){
            case MAIN:
                view = inflater.inflate(R.layout.main_layout,parent,false);
                holder = new MainViewHolder(view);
                break;
            case HORIZONTAL:
                view = inflater.inflate(R.layout.horizontal,parent,false);
                holder = new HorizontalViewHolder(view);
                break;
            case VERTICAL:
                view = inflater.inflate(R.layout.vertical,parent,false);
                holder = new VerticalViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.main_layout,parent,false);
                holder = new MainViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == MAIN){

        }else if(holder.getItemViewType() == VERTICAL){
            verticalView((VerticalViewHolder)holder);
        }else if(holder.getItemViewType() == HORIZONTAL){
            horizontalView((HorizontalViewHolder)holder);
        }
    }

    private void verticalView(VerticalViewHolder holder) {
        OrderAdapter orderAdapter = new OrderAdapter(HomeFragment.getOrderItem(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(orderAdapter);
    }

    private void horizontalView(HorizontalViewHolder holder) {
        ItemStatusAdapter adapter = new ItemStatusAdapter(HomeFragment.getOrderStatus(),context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position) instanceof MainData){
            return  MAIN;
        }

        if(items.get(position) instanceof HorizontalItem){
            return  HORIZONTAL;
        }

        if(items.get(position) instanceof OrderItem){
            return  VERTICAL;
        }

        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerview);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.v_recyclerview);
        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
