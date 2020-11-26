package com.ezen.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1= (TextView) findViewById(R.id.textView);
        text2= (TextView) findViewById(R.id.textView2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.Item1 :
                text1.setText("메뉴 1을 선택");
                break;
            case R.id.Item2 :
                text1.setText("메뉴 2을 선택");
                break;
            case R.id.Item3 :
                text1.setText("메뉴 3을 선택");
                break;
            case R.id.Item4 :
                text1.setText("메뉴 4을 선택");
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}