package com.siricherukuri.manavata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class WhatDoWeDoActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_do_we_do);
    }
    public void MyWeb(View view)
    {
        openUrl("https://manavata.org/education-project/");
    }
    public void openUrl (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }
    public void MyWeb2(View view)
    {
        openUrl2("https://manavata.org/health-project/");
    }
    public void openUrl2 (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }
    public void MyWeb3(View view)
    {
        openUrl3("https://manavata.org/university-project/");
    }
    public void openUrl3 (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }
    public void MyWeb4(View view)
    {
        openUrl4("https://manavata.org/ashrams/");
    }
    public void openUrl4 (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }
    public void MyWeb5(View view)
    {
        openUrl5("https://manavata.org/help-needy/");
    }
    public void openUrl5 (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }
    public void MyWeb6(View view)
    {
        openUrl6("https://manavata.org/environment/");
    }
    public void openUrl6 (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }

}

