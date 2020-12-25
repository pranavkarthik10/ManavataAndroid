package com.siricherukuri.manavata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends MainActivity {

    private Button idLC;
    private Button idAM;
    private Button idY;
    private Button idHC;

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

        idAM = findViewById(R.id.idAM);
        idAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutManavata();
            }
        });

        idY = findViewById(R.id.idY);
        idY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYoga();
            }
        });

        idHC = findViewById(R.id.idHC);
        idHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHealthyCooking();
            }
        });

    }
    public void openLifeCoachButton() {
        Intent intentLC = new Intent(this, lifecoachbutton.class);
        startActivity(intentLC);
    }

    public void openAboutManavata() {
        Intent intentAM = new Intent(this, AboutManavataActivity.class);
        startActivity(intentAM);
    }
    public void openYoga() {
        Intent intentY = new Intent(this, YogaActivity.class);
        startActivity(intentY);
    }
    public void openHealthyCooking() {
        Intent intentHC = new Intent(this, HealthyCookingActivity.class);
        startActivity(intentHC);
    }

}