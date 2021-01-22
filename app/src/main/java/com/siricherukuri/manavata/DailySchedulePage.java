package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class DailySchedulePage extends AppCompatActivity {



    RecyclerView mrecyclerView;
    RecyclerAdapter recyclerAdapter;

    private ImageButton sunrisebutton;
    private ImageButton wakeupbutton;
    private ImageButton yogatimebutton;
    private ImageButton breakfastbutton;
    private ImageButton lunchbutton;
    private ImageButton snacksbutton;

    private int [] alarmimagebuttons = {
            R.drawable.ic_group_36_3, R.drawable.ic_group_38,
            R.drawable.ic_group_39, R.drawable.ic_group_40,
            R.drawable.ic_group_41, R.drawable.ic_group_42};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule_page);

        mrecyclerView = findViewById(R.id.DSRecyclerView);
        recyclerAdapter = new RecyclerAdapter(alarmimagebuttons);
        //mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(recyclerAdapter);

        /*wakeupbutton= (ImageButton) findViewById(R.id.wakeupbutton);
        wakeupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWakeUpTime();
            }
        });
        //sunrisebutton= (ImageButton) findViewById(R.id.sunrisebutton);
        sunrisebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSunriseTime();
            }
        });
        //yogatimebutton = (ImageButton) findViewById(R.id.yogatimebutton);
        yogatimebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYogaTime();
            }
        });
       //breakfastbutton = (ImageButton) findViewById(R.id.breakfastbutton);
        breakfastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBreakfastTime();
            }
        });
        //lunchbutton= (ImageButton) findViewById(R.id.lunchbutton);
        lunchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLunchTime();
            }
        });
        //snacksbutton = (ImageButton) findViewById(R.id.snacksbutton);
        snacksbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSnacksTime();
            }
        });

         */
    }

    public void openWakeUpTime(){
        Intent intentWT = new Intent(this, WakeUpTime.class);
        startActivity(intentWT);
    }
    public void openSunriseTime(){
        Intent intentST = new Intent (this, SunriseTime.class);
        startActivity(intentST);
    }
    public void openYogaTime(){
        Intent intentYT = new Intent(this, YogaTime.class);
        startActivity(intentYT);
    }
    public void openBreakfastTime(){
        Intent intentBT = new Intent(this, BreakfastTime.class);
        startActivity(intentBT);
    }
    public void openLunchTime(){
        Intent intentLT = new Intent(this, LunchTime.class);
        startActivity(intentLT);
    }
    public void openSnacksTime(){
        Intent intentST = new Intent(this, SnacksTime.class);
        startActivity(intentST);
    }
}