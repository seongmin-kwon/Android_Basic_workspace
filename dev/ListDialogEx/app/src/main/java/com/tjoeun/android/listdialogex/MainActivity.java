package com.tjoeun.android.listdialogex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String [] data1 = {"토고", "프랑스", "스위스", "스페인", "일본", "독일",
            "브라질", "대한민국"};
    int [] data2 = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3,
            R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6,
            R.drawable.imgflag7, R.drawable.imgflag8
    };

    TextView text1, text2;
    String [] data3 = {
            "로메", "파리", "베른", "마드리드", "도쿄", "베를린", "브라질리아", "서울"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView1);
        text2 = (TextView)findViewById(R.id.textView2);
    }

    public void btnMethod(View view){
        ArrayList<HashMap<String, Object>> list
                = new ArrayList<HashMap<String, Object>>();
        for(int i = 0 ; i < data2.length ; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);
            list.add(map);
        }
        String [] keys = {"data1", "data2"};
        int [] ids = {R.id.textView, R.id.imageView};

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.row, keys, ids);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("커스텀 리스트 다이얼로그");
        Dialog2Listener listener = new Dialog2Listener();
        builder.setAdapter(adapter, listener);
        builder.setNegativeButton("취소", null);
        builder.show();
    }
    class Dialog2Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text1.setText(data1[which]);
            text2.setText(data3[which]);
        }
    }
}
