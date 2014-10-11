package com.example.numberseekbar;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends Activity {
    private NumberSeekBar pb, pb1, pb2;
    
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    pb.setProgress(pb.getProgress() + 5);
                    pb1.setProgress(pb1.getProgress() + 5);
                    pb2.setProgress(pb2.getProgress() + 10);
                    break;
            }
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numberseekbar);
        pb = (NumberSeekBar)findViewById(R.id.bar0);
        pb1 = (NumberSeekBar)findViewById(R.id.bar1);
        pb2 = (NumberSeekBar)findViewById(R.id.bar2);
        init();
        start();
    }
    
    private void init() {
        pb.setTextSize(20);// 设置字体大小
        pb.setTextColor(Color.WHITE);// 颜色
        pb.setMyPadding(10, 10, 10, 10);// 设置padding 调用setpadding会无效
        pb.setImagePadding(0, 1);// 可以不设置
        pb.setTextPadding(0, 0);// 可以不设置
        
        pb1.setTextSize(20);// 设置字体大小
        pb1.setTextColor(Color.WHITE);// 颜色
        pb1.setMyPadding(10, 10, 10, 10);// 设置padding 调用setpadding会无效
        pb1.setImagePadding(0, 1);// 可以不设置
        pb1.setTextPadding(0, 0);// 可以不设置
        
        pb2.setTextSize(20);// 设置字体大小
        pb2.setTextColor(Color.WHITE);// 颜色
        pb2.setMyPadding(10, 10, 10, 10);// 设置padding 调用setpadding会无效
        pb2.setImagePadding(0, 1);// 可以不设置
        pb2.setTextPadding(0, 0);// 可以不设置
    }
    
    private void start() {
        TimerTask tt = new TimerTask() {
            public void run() {
                handler.sendEmptyMessage(1);
            }
        };
        Timer timer = new Timer();
        timer.schedule(tt, 1000, 2000);
    }
    
}
