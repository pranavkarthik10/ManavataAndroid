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

public class SunriseTime extends AppCompatActivity {

    EditText mSunriseHourText;
    EditText mSunriseMinuteText;
    Button mSunriseAlarmAccept;
    Button mSunrisepick;
    TimePickerDialog ettimePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunrise_time);


        mSunriseHourText = (EditText) findViewById(R.id.sunrise_hour);
        mSunriseMinuteText = (EditText) findViewById(R.id.sunrise_minute);
        mSunrisepick = (Button) findViewById(R.id.sunrisepick);
        mSunriseAlarmAccept = (Button) findViewById(R.id.sunrise_accept);

        mSunriseAlarmAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(mSunriseHourText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(mSunriseMinuteText.getText().toString()));

                startActivity(intent);
            }
        });

        mSunrisepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                ettimePickerDialog = new TimePickerDialog(SunriseTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minutes) {
                        mSunriseHourText.setText(String.format("%02d", hourOfday));
                        mSunriseMinuteText.setText(String.format("%02d", minutes));
                    }
                }, currentHour,currentMinute, false);

                ettimePickerDialog.show();
            }
        });
    }
}