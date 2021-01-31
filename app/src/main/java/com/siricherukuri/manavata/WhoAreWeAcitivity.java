package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;


public class WhoAreWeAcitivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.who_are_we);

        defineButtons();
    }

    public void defineButtons() {
        TextView philosophy = findViewById(R.id.philosophy);
        philosophy.setText(Html.fromHtml("<u>"+philosophy.getText()+"</u>"));
        philosophy.setOnClickListener(buttonClickListener);

        TextView mission = findViewById(R.id.mission);
        mission.setText(Html.fromHtml("<u>"+mission.getText()+"</u>"));
        mission.setOnClickListener(buttonClickListener);

        TextView ourwork = findViewById(R.id.ourwork);
        ourwork.setText(Html.fromHtml("<u>"+ourwork.getText()+"</u>"));
        ourwork.setOnClickListener(buttonClickListener);

        TextView founder = findViewById(R.id.founder);
        founder.setText(Html.fromHtml("<u>"+founder.getText()+"</u>"));
        founder.setOnClickListener(buttonClickListener);

        TextView ourteam = findViewById(R.id.ourteam);
        ourteam.setText(Html.fromHtml("<u>"+ourteam.getText()+"</u>"));
        ourteam.setOnClickListener(buttonClickListener);
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
