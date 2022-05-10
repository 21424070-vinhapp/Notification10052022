package com.example.notification10052022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnOpen, mBtnClose;
    String CHANEL_ID="My chanel";
    NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intit();

        mBtnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tao notification
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANEL_ID);
                //set icon (default)
                builder.setSmallIcon(android.R.drawable.ic_menu_add);
                //set timStamp (thoi gian thong bao da hien len)
                builder.setShowWhen(true);
                //set tieu de
                builder.setContentTitle("Ung dung co phien ban moi");
                //set noi dung thong bao
                builder.setContentText("Ban co muon cap nhat khong");
                //set quyen uu tien cho thong bao co MAX DEFAULT MIN
                builder.setPriority(NotificationCompat.PRIORITY_MAX);
                //set che do rung cho thong bao
                builder.setVibrate(new long[] {0,1000,500,1000});
                //set Light (den) cho thong bao
                builder.setLights(Color.RED,5000,5000);
                //set nhac chuong thong bao
                builder.setSound(Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE+"://"+getPackageName()+"/"+R.raw.baiso01));


                //show notification
                mNotificationManager.notify(1,builder.build());
            }
        });
    }

    private void intit() {
        mBtnClose=findViewById(R.id.btnClose);
        mBtnOpen=findViewById(R.id.btnOpen);
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}