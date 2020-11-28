package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignInActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.emailbutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.googleemailbutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.facebookbutton).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View view) {
            switch (view.getId()) {
                case R.id.emailbutton:
                    startActivity(new Intent(SignInActivity.this, EmailActivity.class));
                    break;
                case R.id.googleemailbutton:
                    startActivity(new Intent(SignInActivity.this, GoogleEmailActivity.class));
                    break;
                case R.id.facebookbutton:
                    startActivity(new Intent(SignInActivity.this, FacebookActivity.class));
                    break;
            }
        }
    };

}

