package com.ezen.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 스피너 는 드롭다운 같은 역할을 하는녀석입니다.
    //스피너 구성을 위한 문자열
    String [] data1 = {"스피너1", "스피너2", "스피너3", "스피너4", "스피너5",
            "스피너6"};
    //뷰의 주소를 담을 참조변수
    Spinner spin1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //참조변수에 연결
        spin1 = (Spinner)findViewById(R.id.spinner);
        text1 = (TextView)findViewById(R.id.textView);
        //어댑터 생성
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data1);
        //그냥 사용할 것이아니라 드롭다운 을 나타내는 항목리스트의 뷰로 변경 설정.
        adapter1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);

        //만들어진 어댑터를 스피너에 적용합니다.
        SpinnerListener listener = new SpinnerListener();
        spin1.setOnItemSelectedListener(listener);
    }
 //방법2
    public void btnMethod(View view){
        // 현재 스피너에 선택되어 있는 항목의 인덱스 값을 추출한다.
        int index = spin1.getSelectedItemPosition();
        text1.setText("선택된 항목 : " + data1[index]);
    }
    //사용자가 항목을 선택했을때 호출되는 메서드
    class SpinnerListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("선택된 항목 : " + data1[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}