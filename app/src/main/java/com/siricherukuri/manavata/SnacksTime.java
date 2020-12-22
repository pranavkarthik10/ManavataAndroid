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

public class SnacksTime extends AppCompatActivity {

    EditText msnacksHourText;
    EditText msnacksMinuteText;
    Button msnacksAlarmAccept;
    Button msnackspick;
    TimePickerDialog ettimePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_time);

        msnacksHourText = (EditText) findViewById(R.id.snacks_hour);
        msnacksMinuteText = (EditText) findViewById(R.id.snacks_minute);
        msnackspick = (Button) findViewById(R.id.snackspick);
        msnacksAlarmAccept = (Button) findViewById(R.id.snacks_accept);

        msnacksAlarmAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(msnacksHourText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(msnacksMinuteText.getText().toString()));

                startActivity(intent);
            }
        });

        msnackspick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                ettimePickerDialog = new TimePickerDialog(SnacksTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minutes) {
                        msnacksHourText.setText(String.format("%02d", hourOfday));
                        msnacksMinuteText.setText(String.format("%02d", minutes));
                    }
                }, currentHour,currentMinute, false);

                ettimePickerDialog.show();
            }
        });
    }
}