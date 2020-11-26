package com.ezen.button_text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //레퍼런스 변수 를 선언
    TextView text1;
    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //각각의 레버펀스변수에 아이디를 입힘
        text1 = (TextView) findViewById(R.id.textView3);
        button1 =(Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        
        //버튼을 눌렀나 안눌렀나 감시하는 리스너가 필요
        BtnListener1 ltn1 = new BtnListener1(); //리스너 객체 생성
        BtnListener2 ltn2  = new BtnListener2();
        BtnListener34 ltn34 = new BtnListener34();
        button1.setOnClickListener(ltn1); //버튼 객체 연결
        button2.setOnClickListener(ltn2);

        button3.setOnClickListener(ltn34);
        button4.setOnClickListener(ltn34);
    }
    //온클릭 리스터를 임플리먼트한 클래스 생성
    class BtnListener1 implements View.OnClickListener{

        @Override //추상화 메서드 오버라이드
        public void onClick(View v) {// 현재클래스의 객체가 연겨뢴 뷰를 클릭하면 실행
            text1.setText("첫번째 버튼이 눌렸어요");
        }
        //v는 클릭된 뷰의 주소가 오는것
    }

    class BtnListener2 implements View.OnClickListener{

        @Override //추상화 메서드 오버라이드
        public void onClick(View v) {// 현재클래스의 객체가 연겨뢴 뷰를 클릭하면 실행
            text1.setText("두번째 버튼이 눌렸어요");
        }
    }
    //이번엔 버튼 3,4기능 둘다 수행하는 하나의 메소드 만들기
    class BtnListener34 implements  View.OnClickListener{

        @Override
        public void onClick(View v) {
            //이벤트 가 발생된 뷰의 id 값을 추출
            int id = v.getId();
            //ID로 분기 한다.
            switch (id){
                case R.id.button3:
                    text1.setText("세번째 버튼이 눌렸습니다.");
                    break;
                case R.id.button4:
                    text1.setText("네번째 버튼이 눌렸습니다.");
                    break;
            }

        }
    }
    // 이렇게 따로 내가 메서드 만들고 엑티브 메인에서 온클릭 에 아이디만 설정해주면된다
    public void btn5Method(View view){
        text1.setText("다섯번째 버튼이 눌렸습니다.");
    }

    public void btn6Method(View view){
        text1.setText("여섯번째 버튼이 눌렸습니다.");
    }
    
    //이제 다 합쳐보자
    public void btn78Method(View view){
        //이벤트 가 발생된 뷰의 id 값을 추출
        int id = view.getId();
        //ID로 분기 한다.
        switch (id){
            case R.id.button7:
                text1.setText("일곱번째 버튼이 눌렸습니다.");
                break;
            case R.id.button8:
                text1.setText("여덜번째 버튼이 눌렸습니다.");
                break;
        }

    }
    
}
