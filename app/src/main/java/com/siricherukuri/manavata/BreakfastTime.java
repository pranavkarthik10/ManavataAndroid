package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class BreakfastTime extends AppCompatActivity {

    EditText mbreakfastHourText;
    EditText mbreakfastMinuteText;
    Button mbreakfastAlarmAccept;
    Button mbreakfastpick;
    TimePickerDialog ettimePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_time);

        mbreakfastHourText = (EditText) findViewById(R.id.breakfast_hour);
        mbreakfastMinuteText = (EditText) findViewById(R.id.breakfast_minute);
        mbreakfastpick = (Button) findViewById(R.id.breakfastpick);
        mbreakfastAlarmAccept = (Button) findViewById(R.id.breakfast_accept);

        mbreakfastAlarmAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(mbreakfastHourText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(mbreakfastMinuteText.getText().toString()));

                startActivity(intent);
            }
        });

        mbreakfastpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                ettimePickerDialog = new TimePickerDialog(BreakfastTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minutes) {
                        mbreakfastHourText.setText(String.format("%02d", hourOfday));
                        mbreakfastMinuteText.setText(String.format("%02d", minutes));
                    }
                }, currentHour,currentMinute, false);

                ettimePickerDialog.show();
            }
        });
    }
}