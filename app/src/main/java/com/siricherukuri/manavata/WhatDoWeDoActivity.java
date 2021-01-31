package com.siricherukuri.manavata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;


public class WhatDoWeDoActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_do_we_do);

        TextView samskaravidya = findViewById(R.id.samskaravidya);
        samskaravidya.setText(Html.fromHtml("<u>" + samskaravidya.getText() + "</u>"));
        samskaravidya.setOnClickListener(buttonClickListener);

        TextView yogaandhealthcare = findViewById(R.id.yogaandhealthcare);
        yogaandhealthcare.setText(Html.fromHtml("<u>" + yogaandhealthcare.getText() + "</u>"));
        yogaandhealthcare.setOnClickListener(buttonClickListener);

        TextView universityforhumanity = findViewById(R.id.universityforhumanity);
        universityforhumanity.setText(Html.fromHtml("<u>" + universityforhumanity.getText() + "</u>"));
        universityforhumanity.setOnClickListener(buttonClickListener);

        TextView ashramandchildcare = findViewById(R.id.ashramandchildcare);
        ashramandchildcare.setText(Html.fromHtml("<u>" + ashramandchildcare.getText() + "</u>"));
        ashramandchildcare.setOnClickListener(buttonClickListener);

        TextView helpneedy = findViewById(R.id.helpneedy);
        helpneedy.setText(Html.fromHtml("<u>" + helpneedy.getText() + "</u>"));
        helpneedy.setOnClickListener(buttonClickListener);

        TextView climatechange = findViewById(R.id.climatechange);
        climatechange.setText(Html.fromHtml("<u>" + climatechange.getText() + "</u>"));
        climatechange.setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.samskaravidya:
                    openUrl("https://manavata.org/education-project/");
                    break;
                case R.id.yogaandhealthcare:
                    openUrl("https://manavata.org/health-project/");
                    break;
                case R.id.universityforhumanity:
                    openUrl("https://manavata.org/university-project/");
                    break;
                case R.id.ashramandchildcare:
                    openUrl("https://manavata.org/ashrams/");
                    break;
                case R.id.helpneedy:
                    openUrl("https://manavata.org/help-needy/");
                    break;

                case R.id.climatechange:
                    openUrl("https://manavata.org/environment/");
                    break;
            }
        }
    };

    public void openUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchWeb);
    }

}
