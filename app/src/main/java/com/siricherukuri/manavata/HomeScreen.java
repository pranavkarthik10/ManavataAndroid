package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button idLC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        idLC = findViewById(R.id.idLC);
        idLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLifeCoachButton();
            }
        });
        defineButton();
    }
    public void defineButton() {
        findViewById(R.id.idAM).setOnClickListener(buttonClickListener);
        findViewById(R.id.idY).setOnClickListener(buttonClickListener);
        findViewById(R.id.idHC).setOnClickListener(buttonClickListener);
    }

    public void openLifeCoachButton() {
        Intent intentLC = new Intent(this, lifecoachbutton.class);
        startActivity(intentLC);
    }
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.idAM:
                    startActivity(new Intent(HomeScreen.this, AboutManavataActivity.class));
                    break;
                case R.id.idY:
                    startActivity(new Intent(HomeScreen.this, YogaActivity.class));
                    break;
                case R.id.idHC:
                    startActivity(new Intent(HomeScreen.this, HealthyCookingActivity.class));
                    break;

            }
        }
    };
}