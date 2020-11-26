package com.ezen.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn1Method(View view) {
        //토스트 객체를 생성합니다.
        Toast t1 = Toast.makeText(this,
                "토스트 메시지 입니다", Toast.LENGTH_SHORT);
        //작성된 토스트를 화면에 보여 줍니다.
        t1.show();
    }

    public void btn2Method(View view) {
        // 토스트를 통해 보여줄 뷰 객체를 생성한다.
        LayoutInflater inflater = getLayoutInflater();
        //v1안에 있는 뷰들을 먼저 추출 합니다.
        View v1 = inflater.inflate(R.layout.custom_toast, null);

        // 뷰가 가지고 있는 뷰를 추출한다.
        ImageView img1 = (ImageView)v1.findViewById(R.id.imageView2);
        TextView text1 = (TextView)v1.findViewById(R.id.textView);

        // 뷰의 배경을 토스트 전용 배경 이미지로 설정한다.
        v1.setBackgroundResource(android.R.drawable.toast_frame);
        img1.setImageResource(R.drawable.ic_launcher_background);
        //텍스트 뷰에 메세지 세팅
        text1.setText("커스텀 토스트");
        text1.setTextColor(Color.BLUE);
        // 생성한 뷰를 토스트 객체에 설정한다.
        Toast t2 = new Toast(this);
        // 토스트 객체에 보여줄 뷰를 설정한다.
        t2.setView(v1);

        // 토스트 메세지의 위치를 설정한다.
        t2.setGravity(Gravity.CENTER, 0, 200);

        // 토스트가 표시될 시간을 설정한다.
        t2.setDuration(Toast.LENGTH_SHORT);

        t2.show();

    }
}