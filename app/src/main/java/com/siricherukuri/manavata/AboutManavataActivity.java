package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutManavataActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_manavata);

        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.whatdowedo).setOnClickListener(buttonClickListener);
        findViewById(R.id.whoarewe).setOnClickListener(buttonClickListener);
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