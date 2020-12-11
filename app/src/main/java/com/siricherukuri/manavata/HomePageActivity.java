package com.siricherukuri.manavata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        defineButton();
    }

    public void defineButton() {
        findViewById(R.id.idAM).setOnClickListener(buttonClickListener);
        findViewById(R.id.idY).setOnClickListener(buttonClickListener);
        findViewById(R.id.idHC).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.aboutmanavata:
                    startActivity(new Intent(HomePageActivity.this, AboutManavataActivity.class));
                    break;
                case R.id.yoga:
                    startActivity(new Intent(HomePageActivity.this, YogaActivity.class));
                    break;
                case R.id.healthycooking:
                    startActivity(new Intent(HomePageActivity.this, HealthyCookingActivity.class));
                    break;

            }
        }
    };
}
