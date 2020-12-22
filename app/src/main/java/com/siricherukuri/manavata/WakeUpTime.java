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

public class WakeUpTime extends AppCompatActivity {

    EditText mWakeupHourText;
    EditText mWakeupMinuteText;
    Button mWakeupAlarmAccept;
    Button mwakeuppick;
    TimePickerDialog ettimePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up_time);

        mWakeupHourText = (EditText) findViewById(R.id.wakeup_hour);
        mWakeupMinuteText = (EditText) findViewById(R.id.wakeup_minute);
        mwakeuppick = (Button) findViewById(R.id.wakeuppick);
        mWakeupAlarmAccept = (Button) findViewById(R.id.wakeup_accept);

        mWakeupAlarmAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(mWakeupHourText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(mWakeupMinuteText.getText().toString()));

                startActivity(intent);
            }
        });

        mwakeuppick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                ettimePickerDialog = new TimePickerDialog(WakeUpTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minutes) {
                        mWakeupHourText.setText(String.format("%02d", hourOfday));
                        mWakeupMinuteText.setText(String.format("%02d", minutes));
                    }
                }, currentHour,currentMinute, false);

                ettimePickerDialog.show();
            }
        });
    }
}