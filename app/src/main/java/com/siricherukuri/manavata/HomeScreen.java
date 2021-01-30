package com.siricherukuri.manavata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import static com.siricherukuri.manavata.SignInActivity.AUTH_TYPE;
import static com.siricherukuri.manavata.SignInActivity.FACEBOOK;
import static com.siricherukuri.manavata.SignInActivity.GOOGLE;

public class HomeScreen extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button idLC;
    private Button idAM;
    private Button idY;
    private Button idHC;
    private Button idPF;
    private GoogleSignInClient mGoogleSignInClient;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    String authType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        drawerLayout = findViewById(R.id.homescreendrawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.rohanstoolbar);

        authType = getIntent().getStringExtra(AUTH_TYPE);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
        String name = getIntent().getStringExtra("userDisplayName");
        idPF.setText("Welcome " + name);

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
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
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

    private void signOut() {
        if (authType != null) {
            if (authType.equalsIgnoreCase(GOOGLE)) {
                mGoogleSignInClient.signOut()
                        .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent login = new Intent(HomeScreen.this, MainActivity.class);
                                startActivity(login);
                                finish();
                            }
                        });
            } else if (authType.equalsIgnoreCase(FACEBOOK)) {
                LoginManager.getInstance().logOut(); {
                    Intent loginF = new Intent(HomeScreen.this, MainActivity.class);
                    startActivity(loginF);
                }
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_lifecoach:
                Intent intentnLC = new Intent(HomeScreen.this, lifecoachbutton.class);
                startActivity(intentnLC);
                break;

            case R.id.nav_yoga:
                Intent intentnY = new Intent(HomeScreen.this, YogaActivity.class);
                startActivity(intentnY);
                break;

            case R.id.nav_healthycooking:
                Intent intentnHC = new Intent(HomeScreen.this, HealthyCookingActivity.class);
                startActivity(intentnHC);
                break;

            case R.id.nav_manavata:
                Intent intentnAM = new Intent(HomeScreen.this, AboutManavataActivity.class);
                startActivity(intentnAM);
                break;

            case R.id.nav_contact:
                Intent intentnC = new Intent(HomeScreen.this, ContactUsActivity.class);
                startActivity(intentnC);
                break;

            case R.id.nav_donate:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://manavata.org/donate-now/"));
                startActivity(browserIntent);
                break;

            case R.id.nav_signout:
                signOut();
                break;

        }

        return true;
    }
}
