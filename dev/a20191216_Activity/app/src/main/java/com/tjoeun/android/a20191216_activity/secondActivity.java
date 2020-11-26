package com.tjoeun.android.a20191216_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void btn1Method(View v){
        // 실행 결과를 셋팅한다.
        setResult(RESULT_OK);
        //현재 액티비티를 종료한다
        finish();
    }
    public void btn2Method(View v){
        // 실행 결과를 셋팅한다.
        setResult(RESULT_CANCELED);
        //현재 액티비티를 종료한다
        finish();
    }
    public void btn3Method(View v){
        // 실행 결과를 셋팅한다.
        setResult(RESULT_FIRST_USER);
        //현재 액티비티를 종료한다
        finish();
    }
    public void btn4Method(View v){
        // 실행 결과를 셋팅한다.
        setResult(RESULT_FIRST_USER + 1);
        //현재 액티비티를 종료한다
        finish();
    }
}
