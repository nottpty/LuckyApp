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

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
