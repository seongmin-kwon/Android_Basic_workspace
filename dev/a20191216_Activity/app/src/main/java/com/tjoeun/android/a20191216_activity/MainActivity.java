package com.tjoeun.android.a20191216_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text4;
    final int SECOND_ACTIVITY = 1;
    final int THIRD_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text4 = (TextView)findViewById(R.id.textView4);
    }

    public void btn1Method(View v){
        Intent intent = new Intent(this, secondActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, SECOND_ACTIVITY);
    }

    public void btn2Method(View v){
        Intent intent = new Intent(this, ThirdActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, THIRD_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SECOND_ACTIVITY :
                    text4.setText("Second Activity에서 돌아옴\n");
                    // resultCode로 분기한다.
                    switch (resultCode){
                        case RESULT_OK :
                            text4.append("RESULT_OK");
                            break;
                        case RESULT_CANCELED :
                            text4.append("RESULT_CANCELED");
                            break;
                        case RESULT_FIRST_USER :
                            text4.append("RESULT_FIRST_USER");
                            break;
                        case RESULT_FIRST_USER + 1 :
                            text4.append("RESULT_FIRST_USER + 1");
                            break;
                    }
                    break;
            case THIRD_ACTIVITY :
                    text4.setText("Third Activity에서 돌아옴");
                    break;
        }
    }
}
