package com.siricherukuri.manavata;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    TimePickerDialog ettimePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    boolean isPM;
    Context mcontext;

    private static final String TAG = "RecyclerAdapter";

    private int [] alarmimagebuttons;

    public RecyclerAdapter (int[] alarmimagebuttons, Context context){

        this.alarmimagebuttons = alarmimagebuttons;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i(TAG, "onCreateViewHolder: ");
        
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.alarm_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position)
    {
        int image_id = alarmimagebuttons [position];
        holder.alarmholder.setImageResource(image_id);
        isPM = (currentHour >= 12);

        calendar = Calendar.getInstance();
        currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        currentMinute = calendar.get(Calendar.MINUTE);
        holder.timeholder.setText(String.format("%02d:%02d %s", (currentHour == 12 || currentHour == 0) ? 12 : currentHour % 12, currentMinute, isPM ? "PM" : "AM"));

        holder.alarmholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ettimePickerDialog = new TimePickerDialog(mcontext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minutes) {
                        holder.timeholder.setText(String.format("%02d:%02d %s", (hourOfday == 12 || hourOfday == 0) ? 12 : hourOfday % 12, minutes, isPM ? "PM" : "AM"));

                        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        intent.putExtra(AlarmClock.EXTRA_HOUR, currentHour);
                        intent.putExtra(AlarmClock.EXTRA_MINUTES, currentMinute);
                        mcontext.startActivity(intent);
                    }
                }, currentHour, currentMinute, false);

                ettimePickerDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return alarmimagebuttons.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView alarmholder;
        TextView timeholder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alarmholder = itemView.findViewById(R.id.alarmholder);
            timeholder = itemView.findViewById(R.id.timeholder);
        }
    }

}
