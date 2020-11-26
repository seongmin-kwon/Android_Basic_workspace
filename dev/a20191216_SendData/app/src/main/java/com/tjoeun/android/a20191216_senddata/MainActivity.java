package com.tjoeun.android.a20191216_senddata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
    }

    public void btn1Method(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        // SecondActivity로 전달한 데이터를 셋팅한다.
        intent.putExtra("data1", 100);
        intent.putExtra("data2", 11.23);
        intent.putExtra("data3", true);
        intent.putExtra("data4", "문자열 1");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case RESULT_OK :
                int value1 = data.getIntExtra("value1", 0);
                double value2 = data.getDoubleExtra("value2", 0.0);
                boolean value3 = data.getBooleanExtra("value3", false);
                String value4 = data.getStringExtra("value4");

                text1.append("\n" + "value1 : " + value1 + "\n");
                text1.append("value2 : " + value2 + "\n");
                text1.append("value3 : " + value3 + "\n");
                text1.append("value4 : " + value4);
                break;
        }
    }
}







