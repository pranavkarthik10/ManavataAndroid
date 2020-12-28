package com.siricherukuri.manavata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class YogaActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
    }
    public void YoutubeChannel2(View view)
    {
        openUrl("https://www.youtube.com/user/manavatauk");
    }
    public void openUrl (String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent. ACTION_VIEW, uri);
        startActivity(launchWeb);
    }
}
