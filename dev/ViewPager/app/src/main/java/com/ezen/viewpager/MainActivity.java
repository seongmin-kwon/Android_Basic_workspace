package com.ezen.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager2 pager1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager1 = (ViewPager2)findViewById(R.id.pager1);
        text1 = (TextView)findViewById(R.id.textView);
    }
}