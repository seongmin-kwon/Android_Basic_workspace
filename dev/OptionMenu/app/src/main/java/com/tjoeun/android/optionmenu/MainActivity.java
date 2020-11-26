package com.tjoeun.android.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
    }

    // 액티비티가 화면에 나타날 때 메뉴 구성을 위해서 호출하는 메서드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // xml을 통해 메뉴를 구성할 수 있는 객체를 추출
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.option_menu, menu);

        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드메뉴1");
        //menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드 메뉴2");
        Menu sub = menu.addSubMenu("코드 메뉴2");
        sub.add(Menu.NONE, Menu.FIRST + 10, Menu.NONE, "코드 서브메뉴1");
        sub.add(Menu.NONE, Menu.FIRST + 20, Menu.NONE, "코드 서브메뉴2");
        menu.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드 메뉴3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case Menu.FIRST :
                text1.setText("코드 메뉴1을 눌렀습니다");
                break;
            case Menu.FIRST + 10 :
                text1.setText("코드 서브메뉴1을 눌렀습니다");
                break;
            case Menu.FIRST + 20 :
                text1.setText("코드 서브메뉴2를 눌렀습니다");
                break;
            case Menu.FIRST + 2 :
                text1.setText("코드 메뉴3을 눌렀습니다");
        }
        /*switch (id){
            case R.id.item1 :
                text1.setText("메뉴1을 눌렀습니다");
                break;
            case R.id.item2_1 :
                text1.setText("서브 메뉴1을 눌렀습니다");
                break;
            case R.id.item2_2 :
                text1.setText("서브 메뉴2를 눌렀습니다");
                break;
            case R.id.item3 :
                text1.setText("메뉴3을 눌렀습니다");
        }*/

        return super.onOptionsItemSelected(item);
    }
}
