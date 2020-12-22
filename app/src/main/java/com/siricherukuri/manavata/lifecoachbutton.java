package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class lifecoachbutton extends AppCompatActivity {

    private ImageButton dailyschedbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecoachbutton);

        dailyschedbutton= (ImageButton) findViewById(R.id.dailyschedbutton);
        dailyschedbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDailySchedulePage();
            }
        });
    }

    public void openDailySchedulePage() {
        Intent intentDS = new Intent(this, DailySchedulePage.class);
        startActivity(intentDS);
}