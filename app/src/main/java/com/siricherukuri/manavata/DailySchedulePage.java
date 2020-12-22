package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DailySchedulePage extends AppCompatActivity {

    private ImageButton sunrisebutton;
    private ImageButton wakeupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule_page);

        wakeupbutton= (ImageButton) findViewById(R.id.wakeupbutton);
        wakeupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWakeUpTime();
            }
        });
        sunrisebutton= (ImageButton) findViewById(R.id.sunrisebutton);
        sunrisebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSunriseTime();
            }
        });
    }


    public void openWakeUpTime(){
        Intent intentWT = new Intent(this, WakeUpTime.class);
        startActivity(intentWT);
    }
    public void openSunriseTime(){
        Intent intentST = new Intent (this, SunriseTime.class);
        startActivity(intentST);
    }
}