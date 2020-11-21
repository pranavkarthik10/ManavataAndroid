package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PhilosophyActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philosophy);

        defineTextViews();
    }

    public void defineTextViews() {
        findViewById(R.id.philosophyinfo).setOnClickListener(buttonClickListener);
        findViewById(R.id.philosophyinfo2).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            switch (view.getId()) {
                case R.id.philosophyinfo:
                    startActivity(new Intent(PhilosophyActivity.this, PhilosophyInfo.class));
                    break;
                case R.id.philosophyinfo2:
                    startActivity(new Intent(PhilosophyActivity.this, PhilosophyInfo.class));
                    break;
            }
        }
    };
}