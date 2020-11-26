package com.ezen.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seek, seek2;
    TextView text1, text2, text3, text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);
        text1 = (TextView)findViewById(R.id.textView1);
        text2 = (TextView)findViewById(R.id.textView2);
        text3 = (TextView)findViewById(R.id.textView3);
        text4 = (TextView)findViewById(R.id.textView4);

        SeekBarListener listener = new SeekBarListener();
        seek.setOnSeekBarChangeListener(listener);
        seek2.setOnSeekBarChangeListener(listener);
    }
    public void btn1Method(View view){
        seek.incrementProgressBy(1);
        seek2.incrementProgressBy(1);
    }
    public void btn2Method(View view){
        seek.incrementProgressBy(-1);
        seek2.incrementProgressBy(-1);
    }
    public void btn3Method(View view){
        seek.setProgress(8);
        seek2.setProgress(3);
    }
    public void btn4Method(View view){
        int value1 = seek.getProgress();
        int value2 = seek2.getProgress();
        text1.setText("seek : " + value1);
        text2.setText("seek2 : " + value2);
    }
    class SeekBarListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int id = seekBar.getId();
            switch (id){
                case R.id.seekBar :
                    text1.setText("첫 번째 SeekBar : " + progress);
                    break;
                case R.id.seekBar2 :
                    text2.setText("두 번째 SeekBar : " + progress);
                    break;
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();

            switch (id){
                case R.id.seekBar :
                    text3.setText("첫 번째 SeekBar를 터치하였습니다");
                    break;
                case R.id.seekBar2 :
                    text4.setText("두 번째 SeekBar를 터치하였습니다");
            }
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch (id){
                case R.id.seekBar :
                    text3.setText("첫 번째 SeekBar를 떼었습니다");
                    break;
                case R.id.seekBar2 :
                    text4.setText("두 번째 SeekBar를 떼었습니다");
                    break;
            }
        }
    }
}