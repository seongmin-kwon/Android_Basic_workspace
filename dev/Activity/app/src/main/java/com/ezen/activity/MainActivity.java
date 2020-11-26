package com.ezen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    //어플이 처음 실행 되고, Activity가 생성될때 자동으로 호출되는 메서드이다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // System.out.println("onCreate 메서드가 호출됨.");
        Log.d("test","onCreate 메서드가 호출됨.");

    }
    //onCreate 메서드 호출이후 바로 자동으로 호출되는 녀석입니다.
    //Activity가 정지 상태가 되었다가 활성 상태로 돌아올 떄 호출됩니다.
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","onStart 메서드가 호출됨.");

    }
    //onstart 메서드가 호출된이후에 자동으로 호출된다.
    //Activity가 일시 정지되었다가 다시 돌아 올때 호출.
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume 메서드가 호출됨.");

    }
    //Activity가 정지 상태가 되었다가 활동 상태로 돌아갈때 onStart전에 호출된다.
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test","onRestart 메서드가 호출됨.");
    }
    // Activity가 일시 정지 상태가 될떄 호출된다.
    //화면상에서 완정히 사라지거나 현재 화면 위에 작은 팝업 창 같은 것이 나타날떄 호출됨.
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause 메서드가 호출됨.");
    }
    //Activity 가 화면에서 사라질떄 호출한다.
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop 메서드가 호출됨.");
    }
    //현재 액티비티의 수행이 완전히 종료되어 메모리상에서 제거될때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy 메서드가 호출됨.");
    }
}