package com.uottawa.lab1main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class SuggestWindow extends AppCompatActivity {
    RatingBar rb;
    Float ratingN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_window);

        rb = (RatingBar)findViewById(R.id.ratingBar);

        ratingN = rb.getRating();


    }

    public void onClick(View view){
        TextView text = (TextView)findViewById(R.id.TipA);
        text.setFocusable(false);
        text.setClickable(false);

         //float total = (ratingN*2.0f);
        text.setText(Float.toString(rb.getRating()+10.0f + rb.getRating()));
        //text.setText(Float.toString(total));

        //text.setText("Tip% is: " + Double.toString(total)+ "%");

    }
    public void onCickReturn(View view){
        Intent intent = new Intent(SuggestWindow.this,Main.class);
        startActivity(intent);
    }
}
