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
import com.bichi.ui.adapter.MainAdapter;
import com.bichi.ui.adapter.OrderAdapter;
import com.bichi.ui.model.HorizontalItem;
import com.bichi.ui.model.MainData;
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

        MainAdapter adapter = new MainAdapter(context,getObject());
        statusRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        statusRecyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Object> getObject() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new MainData("hell"));
        objects.add(getOrderStatus().get(0));
        objects.add(getOrderItem().get(0));
        return objects;
    }

    public static List<OrderItem> getOrderItem() {
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

    public static List<HorizontalItem> getOrderStatus() {
        List<HorizontalItem> orderStatus = new ArrayList<>();
        orderStatus.add(new HorizontalItem("Pending(129)"));
        orderStatus.add(new HorizontalItem("Accepted(13)"));
        orderStatus.add(new HorizontalItem("Shipped(20)"));

        return orderStatus;
    }
}