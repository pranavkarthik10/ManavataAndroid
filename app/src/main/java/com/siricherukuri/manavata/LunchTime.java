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

public class LunchTime extends AppCompatActivity {

    EditText mlunchHourText;
    EditText mlunchMinuteText;
    Button mlunchAlarmAccept;
    Button mlunchpick;
    TimePickerDialog ettimePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_time);

        mlunchHourText = (EditText) findViewById(R.id.lunch_hour);
        mlunchMinuteText = (EditText) findViewById(R.id.lunch_minute);
        mlunchpick = (Button) findViewById(R.id.lunchpick);
        mlunchAlarmAccept = (Button) findViewById(R.id.lunch_accept);

        mlunchAlarmAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(mlunchHourText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(mlunchMinuteText.getText().toString()));

                startActivity(intent);
            }
        });

        mlunchpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                ettimePickerDialog = new TimePickerDialog(LunchTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minutes) {
                        mlunchHourText.setText(String.format("%02d", hourOfday));
                        mlunchMinuteText.setText(String.format("%02d", minutes));
                    }
                }, currentHour,currentMinute, false);

                ettimePickerDialog.show();
            }
        });
    }
}