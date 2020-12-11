package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends MainActivity {

    private Button cancelbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        cancelbutton = (Button) findViewById(R.id.cancelbutton);
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeScreen();
            }
        });

        defineButtons();
    }

    public void defineButtons() {
        findViewById(R.id.emailbutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.googleemailbutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.facebookbutton).setOnClickListener(buttonClickListener);
    }

    public void openHomeScreen(){
        Intent intentHS = new Intent(this, HomeScreen.class);
        startActivity(intentHS);
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

