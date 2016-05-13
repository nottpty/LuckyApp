package com.example.sas_maxnot19.luckyapp.models;

/**
 * Created by SAS-Maxnot19 on 8/5/2559.
 */
public class Zodiac {

    private int day, month;
    private String zodiac;

    public Zodiac(int day, int month){
        this.day = day;
        this.month = month;
    }

    public String getZodiac(){
        findZodiac(day,month);
        return zodiac;
    }

    public void findZodiac(int day, int month){
        //1
        if( (day >= 14 && day <= 31 && month == 1) || (day >= 1 && day <= 12 && month == 2) ){
            zodiac = "munggorn";
        }
        else if ((day >= 13 && day <= 29 && month == 2) || (day >= 1 && day <= 13 && month == 3)){
            zodiac = "gum";
        }
        else if ((day >= 14 && day <= 31 && month == 3) || (day >= 1 && day <= 14 && month == 4)){
            zodiac = "mean";
        }
        else if ((day >= 15 && day <= 30 && month == 4) || (day >= 1 && day <= 14 && month == 5)){
            zodiac = "mezz";
        }
        else if((day >= 15 && day <= 31 && month == 5) || (day >= 1 && day <= 14 && month == 6)){
            zodiac = "purzog";
        }
        else if((day >= 15 && day <= 30 && month == 6) || (day >= 1 && day <= 15 && month == 7)){
            zodiac = "maetun";
        }
        else if((day >= 16 && day <= 31 && month == 7) || (day >= 1 && day <= 16 && month == 8)){
            zodiac = "goragod";
        }
        else if((day >= 17 && day <= 31 && month == 8) || (day >= 1 && day <= 15 && month == 9)){
            zodiac = "sing";
        }
        else if((day >= 16 && day <= 30 && month == 9) || (day >= 1 && day <= 16 && month == 10)){
            zodiac = "gun";
        }
        else if((day >= 17 && day <= 31 && month == 10) || (day >= 1 && day <= 15 && month == 11)){
            zodiac = "tlun";
        }
        else if((day >= 16 && day <= 30 && month == 11) || (day >= 1 && day <= 15 && month == 12)){
            zodiac = "pijig";
        }
        else{
            zodiac = "tanu";
        }
    }
}
