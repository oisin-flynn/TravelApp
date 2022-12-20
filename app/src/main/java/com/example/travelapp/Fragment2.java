package com.example.travelapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment2 extends Fragment {
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        // The layout is defined in the file R.layout.fragment_2.
        View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        // Get a reference to the ImageView with an ID of colosseum.
        img = rootView.findViewById(R.id.colosseum);

        // Make the ImageView visible.
        img.setVisibility(View.VISIBLE);

        // Return the root view for the fragment.
        return rootView;
    }
}
