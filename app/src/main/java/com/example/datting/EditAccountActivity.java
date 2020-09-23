package com.example.datting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class EditAccountActivity extends AppCompatActivity {
    TextView hoten;
    TextView dob;
    TextView gioitinh;
    EditText accName;
    EditText dobAcc;
    RadioButton male;
    RadioButton female;
    ImageView back_btn;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        init();
        i = getIntent();

        accName.setText(i.getStringExtra("name"));

        accName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hoten.setTextColor(Color.parseColor("#E3608C"));
                dob.setTextColor(Color.parseColor("#757171"));
                return false;
            }
        });
        dobAcc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dob.setTextColor(Color.parseColor("#E3608C"));
                hoten.setTextColor(Color.parseColor("#757171"));
                return false;
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void init(){
        hoten = findViewById(R.id.hoten);
        dob= findViewById(R.id.dob);
        gioitinh = findViewById(R.id.sex);

        accName = findViewById(R.id.nameText);
        dobAcc = findViewById(R.id.dobText);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        back_btn = findViewById(R.id.back_btn_acc);
    }
}
