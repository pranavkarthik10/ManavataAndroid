package com.siricherukuri.manavata;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private int [] alarmimagebuttons;

    public RecyclerAdapter (int[] alarmimagebuttons){

        this.alarmimagebuttons = alarmimagebuttons;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        int image_id = alarmimagebuttons [position];
        holder.alarmholder.setImageResource(image_id);

    }

    @Override
    public int getItemCount() {
        return alarmimagebuttons.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton alarmholder;
        TextView timeholder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alarmholder = itemView.findViewById(R.id.alarmholder);
            timeholder = itemView.findViewById(R.id.timeholder);
        }
    }
}
