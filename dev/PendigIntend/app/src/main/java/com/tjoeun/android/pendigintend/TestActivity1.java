package com.tjoeun.android.pendigintend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity1 extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        text1 = (TextView)findViewById(R.id.textView);
        // 액티비티를 실행할 때 사용한 인텐트 객체를 추출한다.
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        int data2 = intent.getIntExtra("data2", 0);

        text1.setText("data1 : " + data1 + "\n");
        text1.append("data2 : " + data2);
    }
}
