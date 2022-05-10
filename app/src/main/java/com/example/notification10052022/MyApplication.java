package com.example.notification10052022;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {
    String CHANEL_ID="My chanel";

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O);
        {
            NotificationChannel notificationChannel=new NotificationChannel(CHANEL_ID,"Demo",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
