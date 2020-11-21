package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FounderActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founder);

        defineTextViews();
        defineImageView();
    }

    public void defineTextViews() {
        findViewById(R.id.founder).setOnClickListener(buttonClickListener);
        findViewById(R.id.founderDefine).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.founder:
                    startActivity(new Intent(FounderActivity.this, FounderInfo.class));
                    break;
                case R.id.founderDefine:
                    startActivity(new Intent(FounderActivity.this, FounderInfo.class));
                    break;
            }
        }
    };

    public void defineImageView() {
        findViewById(R.id.founderImage).setOnClickListener(buttonClickListener1);
    }

    private View.OnClickListener buttonClickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.founderImage:
                    startActivity(new Intent(FounderActivity.this, FounderInfo.class));
                    break;
            }
        }
    };

}
