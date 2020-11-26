package com.tjoeun.android.notificationex2;

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
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        text1.setText(data1);
    }
}
