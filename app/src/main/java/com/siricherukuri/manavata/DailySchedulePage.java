package com.siricherukuri.manavata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class DailySchedulePage extends AppCompatActivity {
    RecyclerView mrecyclerView;
    RecyclerAdapter recyclerAdapter;

    private int[] alarmimagebuttons = {
            R.drawable.ic_group_36_3, R.drawable.ic_group_38,
            R.drawable.ic_group_39, R.drawable.ic_group_40,
            R.drawable.ic_group_41, R.drawable.ic_group_42};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule_page);

        mrecyclerView = findViewById(R.id.DSRecyclerView);
        mrecyclerView.addItemDecoration(new DividerItemDecoration(mrecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerAdapter = new RecyclerAdapter(alarmimagebuttons, this);
        mrecyclerView.setAdapter(recyclerAdapter);
    }
}
