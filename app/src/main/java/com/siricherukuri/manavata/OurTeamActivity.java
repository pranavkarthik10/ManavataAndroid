package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OurTeamActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);

        defineTextViews();

    }
    public void defineTextViews() {
        findViewById(R.id.ourteamTitle).setOnClickListener(buttonClickListener);
        findViewById(R.id.ourteamdefine).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            switch (view.getId()) {
                case R.id.ourteamdefine:
                    startActivity(new Intent(OurTeamActivity.this, OurTeamInfo.class));
                    break;
                case R.id.ourteamTitle:
                    startActivity(new Intent(OurTeamActivity.this, OurTeamInfo.class));
                    break;
            }
        }
    };
}
