package com.tjoeun.android.notificationex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public NotificationCompat.Builder getNotificationBuilder(String id, String name){
        NotificationCompat.Builder builder = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this, id);
        } else {
            builder = new NotificationCompat.Builder(this, id);
        }
        return builder;
    }

    public void btnMethod(View v){
        NotificationCompat.Builder builder
                = getNotificationBuilder("style", "style Notification");
        builder.setContentTitle("코알라");
        builder.setContentText("알림을 펼치고 그림을 터치하면 해당 액티비티로 이동합니다");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);

        NotificationCompat.BigPictureStyle big = new NotificationCompat.BigPictureStyle(builder);
        // 보여줄 이미지를 설정한다.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_koala);
        big.bigPicture(bitmap);
        big.setBigContentTitle("코알라 알림");
        big.setSummaryText("그림을 클릭하면 해당 액티비티로 이동합니다");

        Intent intent1 = new Intent(this, testActivity.class);
        intent1.putExtra("data1", "koala.jpg");

        PendingIntent pending1
                = PendingIntent.getActivity(this, 10, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending1);

        Notification notification = builder.build();
        NotificationManager manager
                = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(40, notification);
    }
}
