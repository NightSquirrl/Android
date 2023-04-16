package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Handler1 extends AppCompatActivity {

    //定义切换的图片的数组id
    int imgids[] = new int[]{
            R.drawable.ic_launcher_background,
            R.drawable.ic_right_arrow,
            R.drawable.shape_editor_normal,
            R.drawable.txt_rectborder,
    };
    int imgstart = 0;
    final Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                //显示下一张图片
                ((ImageView) findViewById(R.id.imgchange)).setImageResource(imgids[imgstart++ % imgids.length]);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler1);

        //使用定时器,每隔200毫秒让handler发送一个空信息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);

            }
        }, 0,200);
    }
}