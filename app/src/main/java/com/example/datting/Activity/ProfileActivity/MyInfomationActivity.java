package com.example.datting.Activity.ProfileActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.datting.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MyInfomationActivity extends AppCompatActivity {
    TextView name;
    TextView age;
    ImageView back_btn,img1,img2,img3,img4,img5,img6;
    Intent i;
    TextView hereFor,addJob,addMySelf;
    RadioGroup choose;
    RadioButton a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_infomation);
        init();
        //================get info name/age=====================
        i = getIntent();
        name.setText(i.getStringExtra("name"));
        age.setText(i.getStringExtra("age"));
        //=================set action===========================
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 3);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 4);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 5);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 6);
            }
        });
        //====================set dialog ToiODayDe======================================================================
        hereFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MyInfomationActivity.this, R.style.BottomSheetTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.imherefor, (LinearLayout) findViewById(R.id.imhereBottomDialog));
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
            }
        });
        //==============add company and job========================================
        addJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyInfomationActivity.this, JobAndStudy.class);
               startActivity(intent);
            }
        });
        //===============add introduce myself=====================================
        addMySelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyInfomationActivity.this, AboutYouActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            Uri imageUri = data.getData();
            img1.setBackgroundColor(Color.parseColor("#00FFFCFC"));
            Glide.with(this)
                    .load(imageUri)
                    .centerCrop()
                    .into(img1);

        }
        if (resultCode == RESULT_OK && requestCode == 2) {
            Uri imageUri = data.getData();
            img2.setBackgroundColor(Color.parseColor("#00FFFCFC"));
            Glide.with(this)
                    .load(imageUri)
                    .centerCrop()
                    .into(img2);
        }
        if (resultCode == RESULT_OK && requestCode == 3) {
            Uri imageUri = data.getData();
            img3.setBackgroundColor(Color.parseColor("#00FFFCFC"));
            Glide.with(this)
                    .load(imageUri)
                    .centerCrop()
                    .into(img3);
        }
        if (resultCode == RESULT_OK && requestCode == 4) {
            Uri imageUri = data.getData();
            img4.setBackgroundColor(Color.parseColor("#00FFFCFC"));
            Glide.with(this)
                    .load(imageUri)
                    .centerCrop()
                    .into(img4);
        }
        if (resultCode == RESULT_OK && requestCode == 5) {
            Uri imageUri = data.getData();
            img5.setBackgroundColor(Color.parseColor("#00FFFCFC"));
            Glide.with(this)
                    .load(imageUri)
                    .centerCrop()
                    .into(img5);
        }
        if (resultCode == RESULT_OK && requestCode == 6) {
            Uri imageUri = data.getData();
            img6.setBackgroundColor(Color.parseColor("#00FFFCFC"));
            Glide.with(this)
                    .load(imageUri)
                    .centerCrop()
                    .into(img6);
        }
    }
    private void init(){
        //================init==================================
        name = findViewById(R.id.tv_name);
        age = findViewById(R.id.tv_age);
        back_btn=findViewById(R.id.back_btn_info);
        img1 = findViewById(R.id.loadImage1);
        img2 = findViewById(R.id.imageView);
        img3 = findViewById(R.id.imageView2);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        hereFor = findViewById(R.id.hereForDialog);
        choose = findViewById(R.id.radioGroup);
        a = findViewById(R.id.radioButton);
        b= findViewById(R.id.radioButton2);
        c= findViewById(R.id.radioButton3);
        d=findViewById(R.id.radioButton4);
        addJob=findViewById(R.id.add_job);
        addMySelf=findViewById(R.id.add_mySefl);
    }
}
