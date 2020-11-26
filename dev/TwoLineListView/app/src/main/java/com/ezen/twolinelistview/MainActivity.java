package com.ezen.twolinelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String [] data1 = {
            "토고", "프랑스", "스위스", "스페인", "일본", "독일"
    };
    String [] data2 = {
            "1", "2", "3", "4", "5", "6"
    };
    ListView list1;
    TextView text0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text0 = (TextView)findViewById(R.id.textView);

        ArrayList<HashMap<String, Object>> data_list
                = new ArrayList<HashMap<String, Object>>();

        for(int i = 0 ; i < data1.length ; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("str1", data1[i]);
            map.put("str2", data1[i]);
            data_list.add(map);
        }
        String [] keys = {"str1", "str2"};
        //여기 text1 text2 는 이미 있는 것을 가져다 사용하는것임. 내가 만든거 말고
        int [] ids = {android.R.id.text1,android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(this,
                data_list, android.R.layout.simple_list_item_2, keys, ids);

        list1.setAdapter(adapter);
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

    }
    class ListListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text0.setText(data1[position]+"("+data2[position]+")");
        }
    }
}