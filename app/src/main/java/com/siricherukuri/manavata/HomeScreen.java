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

public class SignInActivity extends MainActivity {
    private CallbackManager mCallBackManager;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private TextView textViewUser;
    private ImageView mLogo;
    private LoginButton facebookLogin;
    private AccessTokenTracker accessTokenTracker;
    private static String TAG = "FacebookandGoogleAuthentication";
    private Bundle savedInstanceState;
    private FirebaseUser user;

    private SignInButton googleSignIn;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private Button btnSignOut;
    private int RC_SIGN_IN = 1;

    private Button mbypass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mbypass = findViewById(R.id.bypass);
        mbypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this, HomeScreen.class);
                startActivity(i);
            }
        });

        facebookAuthSetup();


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    updateUI(user);

                } else {
                    updateUI(null);
                }
            }
        };

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if (currentAccessToken == null) {
                    mFirebaseAuth.signOut();
                }
            }
        };


        googleSignIn = findViewById(R.id.login_button_google);
        mAuth = FirebaseAuth.getInstance();
        btnSignOut = findViewById(R.id.log_out_google);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(SignInActivity.this, gso);

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                Toast.makeText(SignInActivity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void facebookAuthSetup() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());

        textViewUser = findViewById(R.id.log_in_name);
        mLogo = findViewById(R.id.logo_picture);
        facebookLogin = findViewById(R.id.login_button_facebook);
        facebookLogin.setReadPermissions("email", "public_profile");
        mCallBackManager = CallbackManager.Factory.create();
        facebookLogin.registerCallback(mCallBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "onSuccess" + loginResult);
                handleFacebookToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "onCancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "onError + error");
            }
        });
    }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        } else {
            mCallBackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(SignInActivity.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc.getIdToken());
        } catch (ApiException e) {
            Toast.makeText(SignInActivity.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }

    }

    public void openHomeScreen(String userDisplayName) {
        Intent intentHS = new Intent(SignInActivity.this, HomeScreen.class);
        intentHS.putExtra("userDisplayName", userDisplayName);
        startActivity(intentHS);
    }

    private void FirebaseGoogleAuth(String token) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(token, null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                    openHomeScreen(user.getDisplayName());

                } else {
                    Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }


    private void handleFacebookToken(AccessToken token) {
        Log.d(TAG, "handleFacebookToken" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mFirebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Sign in with credential: successful");
                    user = mFirebaseAuth.getCurrentUser();
                    updateUI(user);
                    openHomeScreen(user.getDisplayName());
                } else {
                    Log.d(TAG, "Sign in with credential: failure", task.getException());
                    updategoogleUI(null);
                }
            }
        });
    }


    private void updateUI(FirebaseUser user) {
        if (user != null) {
            textViewUser.setText(user.getDisplayName());
            if (user.getPhotoUrl() != null) {
                String photoUrl = user.getPhotoUrl().toString();
                photoUrl = photoUrl + "?type=large";
                Picasso.get().load(photoUrl).into(mLogo);
            } else {
                textViewUser.setText("");
                mLogo.setImageResource(R.drawable.facebooklogo);
            }
        }
    }

    private void updategoogleUI(FirebaseUser fUser) {
        btnSignOut.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            String personName = account.getDisplayName();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(SignInActivity.this, personName + personPhoto, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(authStateListener);
        }
    }
}
