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

    String [] data = {"데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6"};

    ListView list1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView3);

        ListAdapter adapter = new ListAdapter();
        list1.setAdapter(adapter);
    }

    class ListAdapter extends BaseAdapter{

        BtnListener listener = new BtnListener();

        @Override
        public int getCount() {
            return data.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row, null);
            }
            TextView sub_text = (TextView)convertView.findViewById(R.id.textView);
            Button sub_btn1 = (Button)convertView.findViewById(R.id.button1);
            Button sub_btn2 = (Button)convertView.findViewById(R.id.button2);

            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);

            sub_btn1.setTag(position);
            sub_btn2.setTag(position);
            sub_text.setText(data[position]);

            return convertView;
        }
    }
    class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            int position = (Integer)v.getTag();
            switch (id){
                case R.id.button1 :
                    text1.setText("첫 번째 버튼을 눌렀습니다 : " + position);
                    break;
                case R.id.button2 :
                    text1.setText("두 번째 버튼을 눌렀습니다 : " + position);
                    break;
            }
        }
    }
}
