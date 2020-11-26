package com.tjoeun.android.camera_01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String[] permission_list = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    String dir_path;

    Uri contentUri;
    ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView)findViewById(R.id.imageView1);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(permission_list, 0);
        } else {
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int a1 : grantResults){
            if(a1 == PackageManager.PERMISSION_DENIED){
                return;
            }
        }
        init();
    }
    public void init(){
        String temp_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        dir_path = temp_path + "/Android/data/" + getPackageName();

        File file = new File(dir_path);
        if(file.exists()==false) file.mkdir();
    }


    public void showCamera(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String file_name = "/temp_" + System.currentTimeMillis() + ".jpg";
        String pic_path = dir_path + file_name;

        File file = new File(pic_path);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            contentUri = FileProvider.getUriForFile(this,
                    "com.tjoeun.android.camera_01.file_provider", file);
        }else{
            contentUri = Uri.fromFile(file);
        }

        intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            Bitmap bitmap = BitmapFactory.decodeFile(contentUri.getPath());
            float degree = getDegree();
            Bitmap bitmap3 = resizeBitmap(2048, bitmap);
            //Bitmap bitmap3 = rotateBitmap(bitmap, degree);

            image1.setImageBitmap(bitmap3);
        }
    }

    public float getDegree(){
        try {
            ExifInterface exif = new ExifInterface(contentUri.getPath());
            int degree = 0;
            int ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);
            switch(ori){
                case ExifInterface.ORIENTATION_ROTATE_90 :
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180 :
                    degree = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270 :
                    degree = 90;
                    break;
            }
            return (float)degree;

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Bitmap rotateBitmap(Bitmap bitmap, float degree){
        try{
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(degree);
            Bitmap resizeBitmap
                    = Bitmap.createBitmap(bitmap, 0,0, width, height, matrix, true);
            bitmap.recycle();
            return resizeBitmap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    public Bitmap resizeBitmap(int targetWidth, Bitmap source){

        double ratio = (double)targetWidth / (double)source.getWidth();
        int targetHeight = (int)(source.getHeight()*ratio);
        Bitmap result = Bitmap.createScaledBitmap(source, targetWidth,targetHeight, false);
        if(result != source)source.recycle();
        return result;
    }
}












