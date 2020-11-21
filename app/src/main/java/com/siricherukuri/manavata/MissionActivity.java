package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MissionActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        defineTextViews();
    }
    public void defineTextViews() {
        findViewById(R.id.mission).setOnClickListener(buttonClickListener);
        findViewById(R.id.missionDefine).setOnClickListener(buttonClickListener);
        findViewById(R.id.missionTitle).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            switch (view.getId()) {
                case R.id.mission:
                    startActivity(new Intent(MissionActivity.this, MissionInfo.class));
                    break;
                case R.id.missionDefine:
                    startActivity(new Intent(MissionActivity.this, MissionInfo.class));
                    break;
                case R.id.missionTitle:
                    startActivity(new Intent(MissionActivity.this, MissionInfo.class));
                    break;
            }
        }
    };
}
