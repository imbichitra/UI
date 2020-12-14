package com.bichi.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        context = getContext();

        RecyclerView rvContacts = view.findViewById(R.id.recyclerview);
        RecyclerView item_RECYCLR = view.findViewById(R.id.order_recyclerview);

        List<String> s = new ArrayList<>();
        s.add("Pending(129)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Accepted(13)");
        s.add("Shipped(20)");
        Adapter adapter = new Adapter(s,getContext());

        ViewCompat.setNestedScrollingEnabled(rvContacts,false);
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rvContacts.setAdapter(adapter);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Order #1263",true,"Today, 11:11PM",R.drawable.ice,79,"COD"));
        orderItems.add(new OrderItem("Order #7263",true,"Yesterday, 12:10PM",R.drawable.sandwitch,100,"PAID"));
        orderItems.add(new OrderItem("Order #9263",true,"Yesterday, 9:11PM",R.drawable.samosa,89,"PAID"));
        OrderAdapter orderAdapter = new OrderAdapter(orderItems,getContext());
        ViewCompat.setNestedScrollingEnabled(item_RECYCLR,false);
        //item_RECYCLR.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        item_RECYCLR.setLayoutManager(new LinearLayoutManager(getContext()));
        item_RECYCLR.setAdapter(orderAdapter);
        return view;
    }
}