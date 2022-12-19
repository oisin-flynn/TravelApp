package com.example.travelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<WondersInfo> wondersInfoArrayList;
    private onWonderClickListener listener;

    public interface onWonderClickListener{
        void onWonderClick(int position);
    }

    public MyAdapter(Context context, ArrayList<WondersInfo> wondersInfoArrayList, onWonderClickListener listener) {
        this.context = context;
        this.wondersInfoArrayList = wondersInfoArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WondersInfo wondersInfo = wondersInfoArrayList.get(position);
        holder.tvHeading.setText(wondersInfo.heading);
        holder.titleImage.setImageResource(wondersInfo.titleImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wondersInfoArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ShapeableImageView titleImage;
        TextView tvHeading;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            tvHeading = itemView.findViewById(R.id.tvHeading);
        }
    }
}
