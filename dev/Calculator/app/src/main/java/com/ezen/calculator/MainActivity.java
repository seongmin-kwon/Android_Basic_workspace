package com.ezen.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textV;

    double firstNum=0;
    double op=0;
    double seconNum=0;
    double result1;
    double result2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textV = (TextView)findViewById(R.id.textViewV);

    }

    public void btnAll(View V) {
        int id = V.getId();
        //처음에 입력시 0있으면 없애기
        if (textV.getText().toString().equals("0")) {
            textV.setText("");
        }
        switch (id) {
            case R.id.btn10:
                textV.append("0");
                break;
            case R.id.btn1:
                textV.append("1");
                break;
            case R.id.btn2:
                textV.append("2");
                break;
            case R.id.btn3:
                textV.append("3");
                break;
            case R.id.btn4:
                textV.append("4");
                break;
            case R.id.btn5:
                textV.append("5");
                break;
            case R.id.btn6:
                textV.append("6");
                break;
            case R.id.btn7:
                textV.append("7");
                break;
            case R.id.btn8:
                textV.append("8");
                break;
            case R.id.btn9:
                textV.append("9");
                break;
            //clr버튼 숫자 날리고 0으로 만들기
            case R.id.btn16:
                textV.setText("0");
                break;
            case R.id.btn11:
                if (!textV.getText().toString().equals("0"))
                    firstNum = Double.parseDouble(textV.getText().toString());
                textV.setText("0");
                op = 1; //더하기
                break;
            case R.id.btn12:
                if (!textV.getText().toString().equals("0"))
                    firstNum = Double.parseDouble(textV.getText().toString());
                textV.setText("0");
                op = 2; //빼기
                break;
            case R.id.btn13:
                if (!textV.getText().toString().equals("0"))
                    firstNum = Double.parseDouble(textV.getText().toString());
                textV.setText("0");
                op = 3; //곱하기
                break;
            case R.id.btn14:
                if (!textV.getText().toString().equals("0"))
                    firstNum = Double.parseDouble(textV.getText().toString());
                else if (textV.getText().toString().equals("0")) {
                    textV.setText("불가능한 연산입니다.");
                } else {
                    break;
                }
                textV.setText("0");
                op = 4; //나누기
                break;
            //=누르면
            case R.id.btn15:
                seconNum = Double.parseDouble(textV.getText().toString());
                if (op == 1) result1 = firstNum + seconNum;
                else if (op == 2) result1 = firstNum - seconNum;
                else if (op == 3) result1 = firstNum * seconNum;
                else if (op == 4) result2 = firstNum / (double) seconNum;
                else result1 = firstNum % seconNum;

                if (op == 4) textV.setText(String.valueOf(result2));
                else textV.setText(String.valueOf(result1));

                break;
            //back 지우기
            case R.id.button19:
                if (textV.getText().toString().length() < 2) {
                    textV.setText("0");
                } else {
                    int i = textV.getText().toString().length();
                    String tmp = new String(textV.getText().toString().substring(0, i - 1));
                    textV.setText(tmp);
                }
                break;
            //제곱근 구하기
            case R.id.button20:
                if (textV.getText().toString().equals("0")) {
                    break;
                } else {
                    double k = Double.parseDouble(textV.getText().toString());
                    double d = Math.sqrt(k);
                    textV.setText(String.valueOf(d));
                }
                break;
            //x분의1로 계산
            case R.id.button21:
                if (textV.getText().toString().equals("0")) {
                    textV.setText("불가능한 연산입니다.");
                } else {
                    double k = Double.parseDouble(textV.getText().toString());
                    double d = 1.0 / k;
                    textV.setText(String.valueOf(d));
                }
                break;
                //소수점 추가하기
            case R.id.button18:
                if (textV.getText().toString().equals("")) {
                    textV.append("0.");
                    break;
                }

                else if(textV.getText().toString().contains(".")){
                    break;
                }else{
                    textV.append(".");
                }
                break;


        }

    }
}