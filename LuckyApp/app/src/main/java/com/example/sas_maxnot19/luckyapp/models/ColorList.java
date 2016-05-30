package com.example.sas_maxnot19.luckyapp.models;

import android.graphics.Bitmap;

/**
 * Created by SAS-Maxnot19 on 20/5/2559.
 */
public class ColorList {

    private Bitmap image;

    public ColorList(Bitmap image){
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
