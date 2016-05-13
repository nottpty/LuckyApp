package com.example.sas_maxnot19.luckyapp.models;

import android.graphics.Bitmap;

/**
 * Created by SAS-Maxnot19 on 7/5/2559.
 */
public class Location {

    private Bitmap image;
    private String title;

    public Location(Bitmap image, String title){
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
