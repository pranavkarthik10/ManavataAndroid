package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button log_in_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log_in_sign_up = (Button) findViewById(R.id.log_in_sign_up);
        log_in_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignInActivity();
            }
        });

    }
    public void openSignInActivity(){
        Intent intentSI = new Intent(this, SignInActivity.class);
        startActivity(intentSI);
    }
}