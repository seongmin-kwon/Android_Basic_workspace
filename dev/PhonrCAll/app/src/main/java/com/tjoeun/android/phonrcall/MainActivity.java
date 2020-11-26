package com.tjoeun.android.phonrcall;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String[] permission_list = {Manifest.permission.CALL_PHONE};
    EditText text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (EditText)findViewById(R.id.editText);
        checkPermission();
    }
    public void btn4Method(View view){
        // 권한 확인 여부를 체크한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            int chk = checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE);
            if(chk == PackageManager.PERMISSION_DENIED) return;
        }
        String num="tel:" + text1.getText().toString();
        Uri uri = Uri.parse(num);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }
    public void checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }
        for(String permission : permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list, 0);
                break;
            }
        }
    }
}
