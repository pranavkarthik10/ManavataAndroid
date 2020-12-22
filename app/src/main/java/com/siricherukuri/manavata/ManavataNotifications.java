package com.siricherukuri.manavata;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class ManavataNotifications extends Application {
    public static final String CHANNEL_1_ID = "SunriseNotification";
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }
    public void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel SunriseNotification = new NotificationChannel(
                    CHANNEL_1_ID,
                    "SunriseAlarm",
                    NotificationManager.IMPORTANCE_HIGH
            );
            SunriseNotification.setDescription("SUNRISE!!!");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(SunriseNotification);
        }
    }
}
