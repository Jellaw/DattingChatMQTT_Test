package com.example.datting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    ImageView back_setting_btn;
    TextView policy;
    TextView acc_security;
    TextView notificion;
    TextView about;
    TextView support;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //Init===================================
        back_setting_btn = findViewById(R.id.back_btn_setting);
        policy = findViewById(R.id.policy);
        acc_security = findViewById(R.id.acc_security);
        notificion = findViewById(R.id.notification);
        about =findViewById(R.id.about);
        support = findViewById(R.id.support);
        //========================================
        back_setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        acc_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acc_security.setBackgroundColor(Color.parseColor("#80EDEAEA"));
                Intent intent = new Intent(SettingActivity.this, EditAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
