package com.tjoeun.android.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text2 = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        int data1 = intent.getIntExtra("data1", 0);
        double data2 = intent.getDoubleExtra("data2", 0.0);

        text2.append("\n" + "data1 : " + data1 + "\n");
        text2.append("data2 : " + data2);
    }
    public void btnMethod(View view){
        Intent intent = new Intent();
        intent.putExtra("value1", 200);
        intent.putExtra("value2", 22.22);
        setResult(RESULT_OK, intent);
        finish();
    }
}
