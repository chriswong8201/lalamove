package com.example.chriswong.lalamove;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Delivery implements Serializable{
    private String description;
    private String image;
//    private ArrayList location;

    public Delivery() {
    }

    public Delivery(String description, String image) {
        this.description = description;
        this.image = image;
        //this.location = location;
    }

//    public void setLocation(ArrayList location) {
//        this.location = location;
//    }

    public void setBitmap(String image) {

        this.image = image;
    }

    public String getBitmap() {

        return image;
    }

    public String getDescription() {
        return description;
    }

//    public ArrayList getLocation() {
//        return location;
//    }

    public void setDescription(String name) {
        this.description = name;
    }

}