package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //    判断是否为空
        String userNameText = userName.getText().toString();
        String passwordText = password.getText().toString();

        if (TextUtils.isEmpty(userNameText) & TextUtils.isEmpty(passwordText)) {
            // EditText为空
            Toast.makeText(this, "They cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            // 创建日期格式化对象
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 获取当前时间
            Date date = new Date();

            // 格式化时间，并将其转换为字符串
            String strDate = dateFormat.format(date);
            // EditText不为空
            // 进行其他操作
            //  携带消息进行跳转
            //  创建意图对象
            Intent intent = new Intent(this, SecondInterface.class);

            //创建一个包裹
            Bundle bundle = new Bundle();
            bundle.putString("time", strDate);
            bundle.putString("username", userNameText);
            bundle.putString("password", passwordText);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

}