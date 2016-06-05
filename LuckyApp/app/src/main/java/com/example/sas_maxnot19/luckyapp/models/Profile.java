package com.example.sas_maxnot19.luckyapp.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SAS-Maxnot19 on 25/4/2559.
 */
public class Profile implements Serializable{
    private String firstname;
    private String lastname;
    private Date date;
    private boolean isMale = true;

    public Profile(String firstname, String lastname, Date date , boolean isMale){
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.isMale = isMale;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDate() {
        return this.date;
    }
    public boolean isMale() {
        return isMale;
    }
}
