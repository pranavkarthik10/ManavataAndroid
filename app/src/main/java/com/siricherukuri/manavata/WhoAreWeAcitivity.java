package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class WhoAreWeAcitivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.who_are_we);

        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.philosophy).setOnClickListener(buttonClickListener);
        findViewById(R.id.mission).setOnClickListener(buttonClickListener);
        findViewById(R.id.ourwork).setOnClickListener(buttonClickListener);
        findViewById(R.id.founder).setOnClickListener(buttonClickListener);
        findViewById(R.id.ourteam).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.philosophy:
                    startActivity(new Intent(WhoAreWeAcitivity.this, PhilosophyActivity.class));
                    break;
                case R.id.mission:
                    startActivity(new Intent(WhoAreWeAcitivity.this, MissionActivity.class));
                    break;
                case R.id.ourwork:
                    startActivity(new Intent(WhoAreWeAcitivity.this, OurWorkActivity.class));
                    break;
                case R.id.founder:
                    startActivity(new Intent(WhoAreWeAcitivity.this, FounderActivity.class));
                    break;
                case R.id.ourteam:
                    startActivity(new Intent(WhoAreWeAcitivity.this, OurTeamActivity.class));
                    break;
            }
        }
    };
}
