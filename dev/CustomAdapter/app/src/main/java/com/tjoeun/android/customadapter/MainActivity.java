package com.tjoeun.android.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] data = {"데이터1", "데이터2", "데이터3", "데이터4", "데이터5",
            "데이터6"};
    ListView list1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.listView);
        text1 = (TextView)findViewById(R.id.textView);

        ListAdapter adapter = new ListAdapter();
        list1.setAdapter(adapter);
    }


    class ListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return data.length;
        }// 리스트 뷰의 항목 개수를 반환하는 메서드

        @Override
        public Object getItem(int position) { return null;  }
        @Override
        public long getItemId(int position) { return 0;  }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row, null);
            } // 만들어진 또는 이미 존재하는 레이아웃을 화면에 표시할 뷰로 변환 - LayoutInflater

            // 뷰를 구성한다.
            TextView sub_text = (TextView)convertView.findViewById(R.id.textView);
            Button sub_btn1 = (Button)convertView.findViewById(R.id.button);
            Button sub_btn2 = (Button)convertView.findViewById(R.id.button2);

            sub_text.setText(data[position]);

            return convertView;
        }
    }
}
