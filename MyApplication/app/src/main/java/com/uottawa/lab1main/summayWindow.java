package com.uottawa.lab1main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class summayWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summay_window);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String numberOfPeople = extras.getString("people");
        String amount = extras.getString("amount");
        String tip = extras.getString("tip");
        String sign = extras.getString("sign");

        //TextView numberofpeople = (TextView)findViewById()
        TextView bill_amount = (TextView)findViewById(R.id.Bill_amount);
        TextView tip_amount = (TextView)findViewById(R.id.Tip_amount);
        TextView total_amount = (TextView)findViewById(R.id.Total_amount);
        TextView tip_per_person = (TextView)findViewById(R.id.Tip_per_person);
        TextView fees = (TextView)findViewById(R.id.Each_person_pays);


        bill_amount.setText("Bill Amount: "+sign+""+ amount);

        tip_amount.setText("Tip Amount: "+sign+""+  Float.toString((Float.parseFloat(tip))/100f *Float.parseFloat(amount)));
        total_amount.setText("Total Amount: "+sign+""+ Float.toString((Float.parseFloat(tip))/100f *Float.parseFloat(amount)+Float.parseFloat(amount)));
        if(Float.parseFloat(numberOfPeople)>1){
            tip_per_person.setVisibility(View.VISIBLE);
            fees.setVisibility(View.VISIBLE);
            tip_per_person.setText("Tip per person: "+sign+""+  Float.toString(((Float.parseFloat(tip))/100f *Float.parseFloat(amount))/Float.parseFloat(numberOfPeople)));
            fees.setText("Each person pays: "+sign+""+ Float.toString(((Float.parseFloat(tip))/100f *Float.parseFloat(amount)+Float.parseFloat(amount))/Float.parseFloat(numberOfPeople)));
        }

        bill_amount.setFocusable(false);
        bill_amount.setClickable(false);
        tip_amount.setFocusable(false);
        tip_amount.setClickable(false);
        total_amount.setFocusable(false);
        total_amount.setClickable(false);
        tip_per_person.setFocusable(false);
        tip_per_person.setClickable(false);
        fees.setFocusable(false);
        fees.setClickable(false);

    }
    public void onClick(View view){
        Intent intent = new Intent(summayWindow.this,Main.class);
        startActivity(intent);
    }

}
