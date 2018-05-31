package com.uottawa.lab1main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class settingWindow extends AppCompatActivity {


    CheckBox cb1, cb2 ,cb3;
    CheckBox[] checkBoxes;
    String[] signs = {"$","€","£"};
    String sign ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_window);
        cb1 = (CheckBox)findViewById(R.id.dollar);
        cb2 = (CheckBox)findViewById(R.id.euro);
        cb3 = (CheckBox)findViewById(R.id.pound);
        checkBoxes = new CheckBox[]{cb1,cb2,cb3};
        sign = "$";

    }
    public void onClickSaveAndReturn(View view){
        TextView tip_percentage = (TextView)findViewById(R.id.tipPercentage);



        String action = "saved!";
        Toast.makeText(settingWindow.this, action,Toast.LENGTH_LONG).show();
        Intent returnIntent = new Intent(settingWindow.this, Main.class);
        returnIntent.putExtra("tipPercentage",tip_percentage.getText().toString());

        for(int i=0;i<3;i++){
            if(checkBoxes[i].isChecked()){
                    sign = signs[i];
            }

        }
        //Log.i("!!!!!!!!!!!!!","CHECK");
        returnIntent.putExtra("MSign",sign);

       // startActivity(returnIntent);
        setResult(1,returnIntent);
        finish();
    }

    public void onCheckboxClicked(View view){
        //Log.i("&&&&&&&&&&&","CHECK");
        boolean checked = ((CheckBox)view).isChecked();
        if(checked){
        switch(view.getId()) {
            case R.id.dollar:
                if (cb1.isChecked()) {
                    if (cb2.isChecked()) {
                        cb2.toggle();
                    }
                    if (cb3.isChecked()) {
                        cb3.toggle();
                    }
                }
            case R.id.euro:
                    if (cb2.isChecked()) {
                        if (cb1.isChecked()) {
                            cb1.toggle();
                        }
                        if (cb3.isChecked()) {
                            cb3.toggle();
                        }
                }
            case R.id.pound:
                if (cb3.isChecked()) {
                    if (cb1.isChecked()) {
                        cb1.toggle();
                    }
                    if (cb2.isChecked()) {
                        cb2.toggle();
                    }
                }
            }
        }
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }
}
