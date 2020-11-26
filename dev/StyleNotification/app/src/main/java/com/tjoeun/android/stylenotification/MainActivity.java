package com.tjoeun.android.stylenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
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
            NotificationManager manager
                    = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel
                    = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this, id);
        } else {
            builder = new NotificationCompat.Builder(this, id);
        }
        return builder;
    }

    public void btn1Method(View v){
        NotificationCompat.Builder  builder
                = getNotificationBuilder("style", "StyleNotofication");
        builder.setContentTitle("Big Picture");
        builder.setContentText("큰 그림의 노피티케이션입니다");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);

        // BigPicture Notification 객체를 생성한다.
        NotificationCompat.BigPictureStyle big = new NotificationCompat.BigPictureStyle(builder);
        //보여줄 이미지를 설정한다
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_android);
        big.bigPicture(bitmap);
        big.setBigContentTitle("큰그림 타이틀");
        big.setSummaryText("써머리 테스트");

        Notification notification = builder.build();
        NotificationManager manager
                = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, notification);
    }

    public void btn2Method(View v){
        NotificationCompat.Builder  builder
                = getNotificationBuilder("style", "StyleNotification");

        builder.setContentTitle("Big Text");
        builder.setContentText("Big Text Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_call);

        NotificationCompat.BigTextStyle big = new NotificationCompat.BigTextStyle(builder);
        big.setSummaryText("Summary Text");
        big.setBigContentTitle("Big Content Title");

        big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세. " +
                "무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세" +
                "가을하늘 공활한데 높고 구름없이 밝은 달은 우리가슴 일편단심일세. " +
                "무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세");

        Notification notification = builder.build();
        NotificationManager manager
                = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(20, notification);

    }


    public void btn3Method(View v){
        NotificationCompat.Builder builder
                = getNotificationBuilder("style", "style Notification");
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSmallIcon(android.R.drawable.ic_menu_day);

        NotificationCompat.InboxStyle inbox = new NotificationCompat.InboxStyle(builder);
        inbox.setSummaryText("Summary TexT");
        inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaa");
        inbox.addLine("bbbbbbbbbbb");
        inbox.addLine("ccccccccccccccccccccccccccccccccccccccccccccc");
        inbox.addLine("dddddddddddddddd");
        inbox.addLine("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        inbox.addLine("fffffffff");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(30, notification);


    }
}

















