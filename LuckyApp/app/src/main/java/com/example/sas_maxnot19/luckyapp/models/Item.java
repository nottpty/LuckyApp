package com.example.sas_maxnot19.luckyapp.models;

import android.graphics.Bitmap;

/**
 * Created by SAS-Maxnot19 on 30/4/2559.
 */
public class Item {

    private Bitmap image;
    private String title;
    private Class activityClass;

    public Item(Bitmap image, String title,Class activityClass){
        this.image = image;
        this.title = title;
        this.activityClass = activityClass;
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

    public Class getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class activityClass) {
        this.activityClass = activityClass;
    }
}
