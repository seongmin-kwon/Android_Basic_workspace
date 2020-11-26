package com.tjoeun.android.notificationex;

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
    public void btn1Method(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("pending", "pending intent");
        builder.setContentTitle("notification 1");
        builder.setContentText("알림 메시지 1입니다");
        builder.setSmallIcon(android.R.drawable.ic_menu_camera);
        builder.setAutoCancel(true);

        NotificationCompat.BigPictureStyle big = new NotificationCompat.BigPictureStyle(builder);
        // 보여줄 이미지를 설정한다.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_koala);
        big.bigPicture(bitmap);
        big.setBigContentTitle("코알라 노티피케이션");
        big.setSummaryText("코알라 액티비티로 이동합니다");

        // 메시지를 터치하면 실행될 Activity 정보를 관리할 객체를 생성한다.
        Intent intent1 = new Intent(this, testActivity.class);
        // 실행될 Activity에 전달할 데이터를 셋팅한다.
        intent1.putExtra("data1", "koala.jpg");

        PendingIntent pending1
                = PendingIntent.getActivity(this, 10, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending1);

        Notification notification = builder.build();
        NotificationManager manager
                = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(30, notification);
    }
}
