package com.tjoeun.android.notificationex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class testActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        text1 = (TextView)findViewById(R.id.textView);
        // 액티비티를 실행할 때 사용한 인텐트 객체를 추출한다.
        Intent intent = getIntent();
        // 데이터를 추출한다.
        String data1 = intent.getStringExtra("data1");

        text1.setText("data1 : " + data1 + "\n");
    }
}
