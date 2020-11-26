package com.tjoeun.android.a20191216_senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text1 = (TextView)findViewById(R.id.textView);
        // 현재 액티비티를 실행하기 위해 사용된 Intent 객체를 추출한다.
        Intent intent = getIntent();
        int data1 = intent.getIntExtra("data1", 0);
        double data2 = intent.getDoubleExtra("data2", 0.0);
        boolean data3 = intent.getBooleanExtra("data3", false);
        String data4 = intent.getStringExtra("data4");

        text1.append("\n" + "data1 : " + data1 + "\n");
        text1.append("data2 : " + data2 + "\n");
        text1.append("data3 : " + data3 + "\n");
        text1.append("data4 : " + data4);
    }

    public void btnMethod(View v){
        // 돌아갈 때 전달할 데이터를 셋팅한다.
        Intent intent = new Intent();
        // 데이터를 셋팅한다.
        intent.putExtra("value1", 200);
        intent.putExtra("value2", 22.22);
        intent.putExtra("value3", true);
        intent.putExtra("value4", "문자열 2");
        // 결과 정보에 intent 객체를 셋팅한다.
        setResult(RESULT_OK, intent);
        finish();
    }
}
