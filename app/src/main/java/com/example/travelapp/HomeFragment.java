package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements MyAdapter.onWonderClickListener {
    private ArrayList<WondersInfo> wonderArrayList;
    private String[] wonderHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize the list data and set up the RecyclerView
        dataInitialize();
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(), wonderArrayList, this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    // Initialize the list data arrays and create WondersInfo objects for each item
    private void dataInitialize(){
        wonderArrayList = new ArrayList<>();
        wonderHeading = new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),
                getString(R.string.head_7)
        };

        imageResourceID = new int[]{
            R.drawable.r_colosseum,
            R.drawable.china_wall,
            R.drawable.taj_mahal,
            R.drawable.redeemer,
            R.drawable.machu_picchu,
            R.drawable.chicen_itza,
            R.drawable.petra
        };

        for(int i=0; i<wonderHeading.length; i++){
            WondersInfo wondersInfo = new WondersInfo(wonderHeading[i], imageResourceID[i]);
            wonderArrayList.add(wondersInfo);
        }

    }

    // Handle click event on a list item
    @Override
    public void onWonderClick(int position) {
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}