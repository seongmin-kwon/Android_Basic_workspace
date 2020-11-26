package com.ezen.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup group1, group2;
    TextView text1, text2;
    RadioButton radio1, radio2, radio3, radio4, radio5, radio6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group1 = (RadioGroup) findViewById(R.id.group1);
        group2 = (RadioGroup) findViewById(R.id.group2);

        radio1 = (RadioButton) findViewById(R.id.radioButton);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        radio3 = (RadioButton) findViewById(R.id.radioButton3);
        radio4 = (RadioButton) findViewById(R.id.radioButton4);
        radio5 = (RadioButton) findViewById(R.id.radioButton5);
        radio6 = (RadioButton) findViewById(R.id.radioButton6);

        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);

        RadioListener ltn = new RadioListener();
        group1.setOnCheckedChangeListener(ltn);
        group2.setOnCheckedChangeListener(ltn);
    }

    //라디오 그룹 용 리스너 함수 만들고 임플리먼츠함.
    class RadioListener implements RadioGroup.OnCheckedChangeListener {
        //어떤 그룹이 전달되어 어떤 아이디가 체크되었는지 전달된다.
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //어떤 그룹인지 먼저 얻어낸다.
            int id = group.getId();
            switch (id) {
                case R.id.group1:
                    switch (checkedId) {
                        case R.id.radioButton:
                            text1.setText("라디오 버튼 이벤트 : 1-1");
                            break;
                        case R.id.radioButton2:
                            text1.setText("라디오 버튼 이벤트 : 1-2");
                            break;
                        case R.id.radioButton3:
                            text1.setText("라디오 버튼 이벤트 : 1-3");
                            break;
                    }
                    break;
                case R.id.group2:
                    switch (checkedId) {
                        case R.id.radioButton4:
                            text2.setText("라디오 버튼 이벤트 : 2-1");
                            break;
                        case R.id.radioButton5:
                            text2.setText("라디오 버튼 이벤트 : 2-2");
                            break;
                        case R.id.radioButton6:
                            text2.setText("라디오 버튼 이벤트 : 2-3");
                            break;
                    }
                    break;
            }
        }
    }

    public void btn1Method(View v) {
        radio2.setChecked(true);
        radio5.setChecked(true);
    }

    public void btn2Method(View v) {
        int id1 = group1.getCheckedRadioButtonId(); // 체크된 라디오 버튼 아이디 get
        int id2 = group2.getCheckedRadioButtonId();

        switch (id1) {
            case R.id.radioButton:
                text1.setText("라디오버튼 1-1이 선택되었습니다");
                break;
            case R.id.radioButton2:
                text1.setText("라디오버튼 1-2이 선택되었습니다");
                break;
            case R.id.radioButton3:
                text1.setText("라디오버튼 1-3이 선택되었습니다");
                break;
        }

        switch (id2) {
            case R.id.radioButton4:
                text2.setText("라디오버튼 2-1이 선택되었습니다");
                break;
            case R.id.radioButton5:
                text2.setText("라디오버튼 2-2이 선택되었습니다");
                break;
            case R.id.radioButton6:
                text2.setText("라디오버튼 2-3이 선택되었습니다");
                break;
        }
    }
}