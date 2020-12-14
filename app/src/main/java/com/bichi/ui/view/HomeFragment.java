package com.bichi.ui.view;

import android.content.Context;
import android.os.Bundle;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bichi.ui.R;
import com.bichi.ui.adapter.ItemStatusAdapter;
import com.bichi.ui.adapter.OrderAdapter;
import com.bichi.ui.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        context = getContext();

        RecyclerView statusRecyclerView = view.findViewById(R.id.recyclerview);
        RecyclerView orderRecyclerView = view.findViewById(R.id.order_recyclerview);

        ItemStatusAdapter adapter = new ItemStatusAdapter(getOrderStatus(),context);

        ViewCompat.setNestedScrollingEnabled(statusRecyclerView,false);
        statusRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        statusRecyclerView.setAdapter(adapter);


        OrderAdapter orderAdapter = new OrderAdapter(getOrderItem(),context);
        ViewCompat.setNestedScrollingEnabled(orderRecyclerView,false);

        orderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderRecyclerView.setAdapter(orderAdapter);
        return view;
    }

    private List<OrderItem> getOrderItem() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Order #1263",true,"Today, 11:11PM",R.drawable.ice,79,"COD"));
        orderItems.add(new OrderItem("Order #7263",true,"Yesterday, 12:10PM",R.drawable.sandwitch,100,"PAID"));
        orderItems.add(new OrderItem("Order #9263",false,"Yesterday, 9:11PM",R.drawable.samosa,89,"PAID"));
        orderItems.add(new OrderItem("Order #7263",true,"Yesterday, 12:10PM",R.drawable.sandwitch,100,"PAID"));
        orderItems.add(new OrderItem("Order #9263",false,"Yesterday, 9:11PM",R.drawable.samosa,89,"PAID"));
        orderItems.add(new OrderItem("Order #7263",true,"Yesterday, 12:10PM",R.drawable.sandwitch,100,"PAID"));
        orderItems.add(new OrderItem("Order #9263",false,"Yesterday, 9:11PM",R.drawable.samosa,89,"PAID"));
        orderItems.add(new OrderItem("Order #7263",true,"Yesterday, 12:10PM",R.drawable.sandwitch,100,"PAID"));
        orderItems.add(new OrderItem("Order #9263",false,"Yesterday, 9:11PM",R.drawable.samosa,89,"PAID"));

        return orderItems;
    }

    private List<String> getOrderStatus() {
        List<String> orderStatus = new ArrayList<>();
        orderStatus.add("Pending(129)");
        orderStatus.add("Accepted(13)");
        orderStatus.add("Shipped(20)");

        return orderStatus;
    }
}