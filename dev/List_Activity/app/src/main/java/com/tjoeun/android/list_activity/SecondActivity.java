package com.tjoeun.android.list_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int [] imgRes = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
            R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    };
    String [] data1 = {
            "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    };
    String [] data2 = {
            "togo", "france", "swiss", "spain", "japan", "german", "brazil", "korea"
    };
    ImageView image2;
    TextView text1, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        image2 = (ImageView)findViewById(R.id.imageView2);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        image2.setImageResource(imgRes[position]);
        text1.setText(data1[position]);
        text2.setText(data2[position]);
    }
}
