package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondInterface extends AppCompatActivity implements View.OnClickListener {
    private TextView receive_username;
    private TextView receive_password;
    private TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_interface);
        receive_username = findViewById(R.id.receive_username);
        receive_password = findViewById(R.id.receive_password);
        timeView =  findViewById(R.id.currentTime);
        findViewById(R.id.returnLast).setOnClickListener(this);
//        从上一个页面获取包裹
        Bundle bundle = getIntent().getExtras();

        String time = bundle.getString("time");
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        timeView.setText(time);
        receive_username.setText(username);
        receive_password.setText(password);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}