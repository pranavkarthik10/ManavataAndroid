package com.siricherukuri.manavata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;

public class HomeScreen extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button idLC;
    private Button idAM;
    private Button idY;
    private Button idHC;
    private Button idPF;
    private Button nav_signout;
    private GoogleSignInClient mGoogleSignInClient;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        drawerLayout = findViewById(R.id.homescreendrawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.rohanstoolbar);


        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        idLC = findViewById(R.id.idLC);
        idLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLifeCoachButton();
            }
        });

        idPF = findViewById(R.id.idPF);
        idPF.setText("Welcome " + getIntent().getStringExtra("userDisplayName"));

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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case  R.id.nav_lifecoach:
                Intent intentnLC = new Intent(HomeScreen.this,lifecoachbutton.class);
                startActivity(intentnLC);
                break;

            case  R.id.nav_yoga:
                Intent intentnY = new Intent(HomeScreen.this,YogaActivity.class);
                startActivity(intentnY);
                break;

            case  R.id.nav_healthycooking:
                Intent intentnHC = new Intent(HomeScreen.this,HealthyCookingActivity.class);
                startActivity(intentnHC);
                break;

            case  R.id.nav_manavata:
                Intent intentnAM = new Intent(HomeScreen.this,AboutManavataActivity.class);
                startActivity(intentnAM);
                break;

            case  R.id.nav_contact:
                Intent intentnC = new Intent(HomeScreen.this,ContactUsActivity.class);
                startActivity(intentnC);
                break;

            case R.id.nav_signout:
                Intent intentnSO = new Intent(HomeScreen.this,MainActivity.class);
                startActivity(intentnSO);
                break;

        }

        return true;
    }
}