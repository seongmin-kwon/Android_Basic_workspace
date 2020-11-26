package com.tjoeun.android.contextex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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

    String [] data3 = {
            "로메", "파리", "베른", "마드리드", "도쿄", "베를린", "브라질리아", "서울"
    };

    ListView list1;
    TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text3 = (TextView)findViewById(R.id.textView3);
        ArrayList<HashMap<String, Object>> data_list = new ArrayList<HashMap<String, Object>>();
        for(int i = 0 ; i < imgRes.length ; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("flag", imgRes[i]);
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);

            data_list.add(map);
        }
        String [] keys = {"flag", "data1", "data2"};
        int [] ids = {R.id.imageView, R.id.textView, R.id.textView2};
        SimpleAdapter adapter
                = new SimpleAdapter(this, data_list, R.layout.row, keys, ids);
        list1.setAdapter(adapter);

        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

        registerForContextMenu(list1);
    }

    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            text3.setText(data1[position]);
        }
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        // 사용가 길게 누르면 뷰의 주소 값을 얻어온다.
        int view_id = v.getId();

        AdapterView.AdapterContextMenuInfo info
                = (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle("리스트 뷰의 메뉴 : " + info.position);
        inflater.inflate(R.menu.listview_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        int position = 0;
        if(info != null && info instanceof AdapterView.AdapterContextMenuInfo){
            AdapterView.AdapterContextMenuInfo info2
                    = (AdapterView.AdapterContextMenuInfo)info;
            position = info2.position;
        }
        switch (id){
            case R.id.list_item1 :
                text3.setText(data1[position]);
                break;
            case R.id.list_item2 :
                text3.setText(data3[position]);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
