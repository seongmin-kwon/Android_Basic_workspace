package com.tjoeun.android.list_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    int [] imgRes = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3,
            R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6,
            R.drawable.imgflag7, R.drawable.imgflag8
    };
    String [] data1 = {
            "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    };
    String [] data2 = {
            "togo", "france", "swiss", "spain", "japan", "german", "brazil", "korea"
    };
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        ArrayList<HashMap<String, Object>> data_list
                = new ArrayList<HashMap<String, Object>>();
        for(int i = 0 ; i < imgRes.length ; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("flag", imgRes[i]);
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);
            data_list.add(map);
        }
        String [] keys = {"flag", "data1", "data2"};
        int [] ids = {R.id.imageView, R.id.textView4, R.id.textView5};
        SimpleAdapter adapter
                = new SimpleAdapter(this, data_list, R.layout.row, keys, ids);
        list1.setAdapter(adapter);
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);
    }
    public void executeActivity(int position){
        Intent intent = new Intent(this , SecondActivity.class );
        intent.putExtra("position", position);
        startActivity(intent);
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            executeActivity(position);
        }
    }
}
