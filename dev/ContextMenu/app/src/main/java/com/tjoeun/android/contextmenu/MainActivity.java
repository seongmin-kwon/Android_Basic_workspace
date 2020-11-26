package com.tjoeun.android.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    ListView list1;
    String [] data1 = {"항목1", "항목2", "항목3", "항목4", "항목5"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        list1 = (ListView)findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1, data1);
        list1.setAdapter(adapter);

        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

        registerForContextMenu(text1);
        registerForContextMenu(list1);
        //손가락으로 길게 꾹 누르면 메뉴가 화면에 표시되는 개체(뷰)로 등록
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("item click : " + data1[position]);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                            ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        //새로 생성한 메뉴리소스를 화면에 표시할 뷰로 변환해주는 객체 생성

        int view_id = v.getId();
        //현재 길게 누른 뷰가 어떤것인지 아이디를 얻어옴

        switch(view_id){
            case R.id.textView:
                menu.setHeaderTitle("텍스트 뷰의 컨텍스트 메뉴");
                //메뉴에 상단에 표시될 메뉴 타이틀 표시
                inflater.inflate(R.menu.textview_menu, menu);
                // 새로 생성한 메뉴리소스를 뷰로 변환
                break;
            case R.id.list1:
                AdapterView.AdapterContextMenuInfo info
                                = (AdapterView.AdapterContextMenuInfo)menuInfo;
                menu.setHeaderTitle("리스트 뷰의 메뉴 : " + info.position);
                inflater.inflate(R.menu.listview_menu, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        // 사용자가 선택한 메뉴 항목의 id를 추출한다.
        int id = item.getItemId();
        // 사용자가 길게 누른 리스트의 항목 인덱스를 가지고 있는 객체를 추출한다.
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        int position = 0;
        if(info != null && info instanceof AdapterView.AdapterContextMenuInfo){
            AdapterView.AdapterContextMenuInfo info2
                                            = (AdapterView.AdapterContextMenuInfo)info;
            position = info2.position;
        }
        switch (id){
            case R.id.text_item1 :
                text1.setText("텍스트뷰의 메뉴1을 선택하였습니다");
                break;
            case R.id.text_item2 :
                text1.setText("텍스트뷰의 메뉴2를 선택하였습니다");
                break;
            case R.id.list_item1 :
                text1.setText("리스트뷰의 메뉴1을 선택하였습니다 : " + position);
                break;
            case R.id.list_item2 :
                text1.setText("리스트뷰의 메뉴2를 선택하였습니다 : " + position);
                break;
        }
        return super.onContextItemSelected(item);
    }


}












