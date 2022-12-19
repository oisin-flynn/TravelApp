package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.imageView);

        ArrayList<Integer> myImages = new ArrayList<Integer>();
        myImages.add(R.drawable.r_colosseum);
        myImages.add(R.drawable.china_wall);
        myImages.add(R.drawable.chicen_itza);
        myImages.add(R.drawable.r_colosseum);
        myImages.add(R.drawable.chicen_itza);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //The key argument here must match that used in the other activity
            Integer id = extras.getInt("position");
            img.setImageResource(myImages.get(id));
        }
    }

}