package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class AboutManavataActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_manavata);

        defineButtons();
    }

    public void defineButtons() {
        TextView whatWedo = findViewById(R.id.whatdowedo);
        whatWedo.setText(Html.fromHtml("<u>"+whatWedo.getText()+"</u>"));
        whatWedo.setOnClickListener(buttonClickListener);
        TextView whoarewe = findViewById(R.id.whoarewe);
        whoarewe.setText(Html.fromHtml("<u>"+whoarewe.getText()+"</u>"));
        whoarewe.setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            switch (view.getId()) {
                case R.id.whatdowedo:
                    startActivity(new Intent(AboutManavataActivity.this, WhatDoWeDoActivity.class));
                    break;
                case R.id.whoarewe:
                    startActivity(new Intent(AboutManavataActivity.this, WhoAreWeAcitivity.class));
                    break;
            }
        }
    };
}
