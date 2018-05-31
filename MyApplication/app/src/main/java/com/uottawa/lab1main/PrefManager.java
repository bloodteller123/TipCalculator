package com.uottawa.lab1main;

/**
 * Created by 10792 on 5/22/2018.
 */


import android.content.Context;
import android.content.SharedPreferences;
public class PrefManager {

        Context context;
        PrefManager(Context context){
            this.context = context;
        }
        public void saveTipP(String tip){
            SharedPreferences.Editor editor = context.getSharedPreferences("Tip",Context.MODE_PRIVATE).edit();
            editor.putString("tip",tip);
            editor.apply();

        }

        public String getTipP(){
            SharedPreferences sharedPreferences = context.getSharedPreferences("Tip",Context.MODE_PRIVATE);

            return sharedPreferences.getString("tip","");
        }

}
