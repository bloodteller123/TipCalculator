package com.uottawa.lab1main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.content.Context;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main extends AppCompatActivity {

    static final int SaveRequest = 1;
    TextView tip;
    TextView numberOfPeople;
    TextView amount;
    String tipPercentage;
    String sign = "$";
    String sighM;

    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set default value
        numberOfPeople = (TextView) findViewById(R.id.people);
        numberOfPeople.setText("1");

        if(new PrefManager(this).getTipP()!=null){
           tip = (TextView)findViewById(R.id.tip);
            tip.setText(new PrefManager(this).getTipP());
        }
    }
    public void onClickSummaryButton(View view){

            numberOfPeople = (TextView) findViewById(R.id.people);
            amount = (TextView) findViewById(R.id.amount);
            tip = (TextView) findViewById(R.id.tip);


        if(check(numberOfPeople, amount, tip)) {
            Intent intent = new Intent(Main.this, summayWindow.class);
            Bundle extra = new Bundle();
            extra.putString("people", numberOfPeople.getText().toString());
            extra.putString("amount", amount.getText().toString());
            extra.putString("tip", tip.getText().toString());
            sighM = sign;
            extra.putString("sign", sighM);
            intent.putExtras(extra);
            startActivity(intent);
        }
        else{
            Context context = getApplicationContext();
            alert();
            Toast toast = Toast.makeText(context, "Please Do It Now", Toast.LENGTH_SHORT);
            toast.show();
            //return;
        }
    }
    public void onClickSetting(View view){
        Intent intent = new Intent(Main.this,settingWindow.class);
        startActivityForResult(intent,SaveRequest);

    }

    public void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        TextView Msign = (TextView)findViewById(R.id.sign);
        if(requestCode == SaveRequest){
            tipPercentage = data.getStringExtra("tipPercentage").toString();
            sign = data.getStringExtra("MSign");
            saveTip(tipPercentage);
            tip.setText(tipPercentage);
            Msign.setText(sign);

         }
    }

    private void saveTip(String tipP){
        new PrefManager(this).saveTipP(tipP);

    }

    public void onClickSuggest(View view){
        Intent intent = new Intent(Main.this,SuggestWindow.class);
        startActivity(intent);
    }


    private boolean check(TextView NOP,TextView amount, TextView tip){
        if( TextUtils.isEmpty(NOP.getText().toString()) || TextUtils.isEmpty(amount.getText().toString()) || TextUtils.isEmpty(tip.getText().toString())){
            return false;
        }
        if(Float.parseFloat(NOP.getText().toString())<=0 ||Float.parseFloat(NOP.getText().toString())>=1000|| Float.parseFloat(amount.getText().toString())<=0 || Float.parseFloat(tip.getText().toString())<=0 ||Float.parseFloat(tip.getText().toString())>=100 ){
            return false;
        }
        return true;
    }

    private void alert(){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Warning! ").setMessage("Please Fill All The Info!\n Please Use Valid Integers!");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {

                                }
                            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

    }

}




