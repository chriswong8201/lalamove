package com.example.chriswong.lalamove;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private List<Delivery> deliveryList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public ImageView image;
        public ArrayList location;

        public MyViewHolder(View view) {
            super(view);
            description = (TextView) view.findViewById(R.id.description);
            image = (ImageView) view.findViewById(R.id.image);
            //location = (TextView) view.findViewById(R.id.year);
        }
    }


    public RecycleViewAdapter(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.delivery_row_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Context context = holder.itemView.getContext();

        final Delivery delivery = deliveryList.get(position);
        holder.description.setText(delivery.getDescription());
        Picasso.get().load(delivery.getBitmap()).into(holder.image);
        //holder.image.setImageBitmap(delivery.getBitmap());
        //holder.year.setText(movie.getYear());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context,String.valueOf(position),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailsDelivery.class);
                intent.putExtra("DeliveryDetails", (Serializable) delivery);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return deliveryList.size();
    }
}