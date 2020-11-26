package com.tjoeun.android.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list1;
    TextView text1;

    // 리스트뷰 구성을 위해 필요한 문자열 배열
    String [] data1 = {
            "리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6",
            "리스트7", "리스트8", "리스트9", "리스트10", "리스트11", "리스트12",
            "리스트13", "리스트14", "리스트15", "리스트16", "리스트17", "리스트18"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.listView);
        text1 = (TextView)findViewById(R.id.textView);
        // 몇 개의 항목을 보여줄 것인가  ->  배열이나 리스트의 항목 갯수
        //각 항목에 어떤 데이터를 보여줄 것인가 -> 배열이나 리스트에 들어있는 값
        //각 항목은 어떤 모양으로 보여줄것인가 -> 레이아웃

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data1);
        list1.setAdapter(adapter);

        ListViewListener ltn = new ListViewListener();
        list1.setOnItemClickListener(ltn);
    }

    class ListViewListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("'" + data1[position] + "' 아이템이 터치되었습니다");
        }
    }
}
