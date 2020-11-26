package com.tjoeun.android.fileio;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    String [] permission_list = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    TextView text1;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        checkPermission();

        File f1 = Environment.getExternalStorageDirectory();

        String a1 = f1.getAbsolutePath();
        String a2 = getPackageName();
        path = a1 + "/android/data/" + a2;
    }

    public void checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return;
        for(String permission : permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list, 0);
                break;
            }
        }
    }
    public void btn1Method(View v){
        try {
            FileOutputStream fos = openFileOutput("myFile.dat", MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(100);
            dos.writeDouble(12.12);
            dos.writeBoolean(true);
            dos.writeUTF("문자열(String) 1");

            dos.flush();
            dos.close();

            text1.setText("내부 저장소 쓰기 완료");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void btn2Method(View v){
        try {
            FileInputStream fis = openFileInput("myFile.dat");
            DataInputStream dis = new DataInputStream(fis);

            int data1 = dis.readInt();
            double data2 = dis.readDouble();
            boolean data3 = dis.readBoolean();
            String data4 = dis.readUTF();

            dis.close();

            text1.setText("data1 : " + data1 + "\n");
            text1.append("data2 : " + data2 + "\n");
            text1.append("data3 : " + data3 + "\n");
            text1.append("data4 : " + data4);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void checkExternalDirectory(){
        // 외부저장소 경로가 있는지 확인하고 없으면 생성한다.
        File file = new File(path);
        if(file.exists() == false){
            file.mkdir();
        }
    }

    public void btn3Method(View view){

        try{
            checkExternalDirectory();
            FileOutputStream fos = new FileOutputStream(path + "/sd_file.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(200);
            dos.writeDouble(22.22);
            dos.writeBoolean(false);
            dos.writeUTF("문자열2");

            dos.flush();
            dos.close();

            text1.setText("외부 저장소 쓰기 완료");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void btn4Method(View view){
        try{
            FileInputStream fis = new FileInputStream(path + "/sd_file.dat");
            DataInputStream dis = new DataInputStream(fis);
            int data1 = dis.readInt();
            double data2 = dis.readDouble();
            boolean data3 = dis.readBoolean();
            String data4 = dis.readUTF();

            dis.close();

            text1.setText("data1 : " + data1 + "\n");
            text1.append("data2 : " + data2 + "\n");
            text1.append("data3 : " + data3 + "\n");
            text1.append("data4 : " + data4);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
