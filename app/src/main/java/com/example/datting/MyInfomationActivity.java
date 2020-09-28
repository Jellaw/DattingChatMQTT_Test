package com.example.datting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyInfomationActivity extends AppCompatActivity {
    TextView name;
    TextView age;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_infomation);
//================init==================================
        name = findViewById(R.id.tv_name);
        age = findViewById(R.id.tv_age);
//================get info name/age=====================
        i = getIntent();
        name.setText(i.getStringExtra("name"));
        age.setText(i.getStringExtra("age"));
    }
}
