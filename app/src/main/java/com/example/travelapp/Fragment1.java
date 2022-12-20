package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
    Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        // The layout is defined in the file R.layout.fragment_1.
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        // Get a reference to the button with an ID of btn1.
        btn = rootView.findViewById(R.id.btn1);

        // Set up a click listener for the button.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, create an Intent to start the MainActivity.
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                // Start the activity.
                startActivity(intent);
            }
        });

        // Return the root view for the fragment.
        return rootView;
    }
}
