package com.tjoeun.android.a20191216_sendobject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
    }

    public void btnMethod(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        TestClass t1 = new TestClass();
        t1.data10 = 100;
        t1.data20 = "문자열1";

        intent.putExtra("test1", t1);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            // 객체를 추출한다.
            TestClass t2 = data.getParcelableExtra("test2");

            text1.append( "\n"+ "t2.data10 : " + t2.data10 + "\n");
            text1.append("t2.data20 : " + t2.data20);
        }
    }
}










