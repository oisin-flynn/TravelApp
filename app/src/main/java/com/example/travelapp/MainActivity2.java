package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView txt;
    ImageView img;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.textView);
        img = findViewById(R.id.imageView);
        description = findViewById(R.id.textDesc);

        ArrayList<String> myTitles = new ArrayList<String>();
        Resources res = getResources();
        myTitles.add(res.getString(R.string.head_1));
        myTitles.add(res.getString(R.string.head_2));
        myTitles.add(res.getString(R.string.head_3));
        myTitles.add(res.getString(R.string.head_4));
        myTitles.add(res.getString(R.string.head_5));
        myTitles.add(res.getString(R.string.head_6));
        myTitles.add(res.getString(R.string.head_7));

        ArrayList<Integer> myImages = new ArrayList<Integer>();
        myImages.add(R.drawable.r_colosseum);
        myImages.add(R.drawable.china_wall);
        myImages.add(R.drawable.taj_mahal);
        myImages.add(R.drawable.redeemer);
        myImages.add(R.drawable.machu_picchu);
        myImages.add(R.drawable.chicen_itza);
        myImages.add(R.drawable.petra);

        ArrayList<String> myDescs = new ArrayList<>();
        Resources resources = getResources();
        myDescs.add(resources.getString(R.string.desc_1));
        myDescs.add(resources.getString(R.string.desc_2));
        myDescs.add(resources.getString(R.string.desc_3));
        myDescs.add(resources.getString(R.string.desc_4));
        myDescs.add(resources.getString(R.string.desc_5));
        myDescs.add(resources.getString(R.string.desc_6));
        myDescs.add(resources.getString(R.string.desc_7));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //The key argument here must match that used in the other activity
            int id = extras.getInt("position");
            img.setImageResource(myImages.get(id));
            txt.setText(myTitles.get(id));
            description.setText(myDescs.get(id));
        }
    }

}