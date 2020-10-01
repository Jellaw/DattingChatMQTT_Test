package com.example.datting.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.datting.Activity.ProfileActivity.EditAccountActivity;
import com.example.datting.Activity.ProfileActivity.MyInfomationActivity;
import com.example.datting.R;
import com.example.datting.Activity.ProfileActivity.SettingActivity;


import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {
    private static final int CODE_SETTING = 100;
    ImageView avatar;
    TextView name;
    TextView age;
    ImageView setting_btn;
    TextView loadInfo;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;


    private com.example.datting.ui.profile.ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(com.example.datting.ui.profile.ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        init(root);
        return root;
    }
    private  void init(View root){
        loadInfo = root.findViewById(R.id.my_info);
        avatar = root.findViewById(R.id.avatar);
        name = root.findViewById(R.id.name_profile);
        age = root.findViewById(R.id.age_profile);
        setting_btn = root.findViewById(R.id.setting_btn_profile);
        Glide.with(getActivity())
                .load(R.drawable.avatar)
                .into(avatar);
        name.setText("Nam Anh");
        age.setText("06");
        //=================set action====================================
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditAccountActivity.class);
                final String acc_name = (String) name.getText();
                intent.putExtra("name", acc_name);
                startActivityForResult(intent, CODE_SETTING);
            }
        });
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
            }
        });
        loadInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyInfomationActivity.class);
                final String acc_name = (String) name.getText();
                final String acc_age = (String) age.getText();
                intent.putExtra("name", acc_name);
                intent.putExtra("age", acc_age);
                getActivity().startActivity(intent);
            }
        });
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODE_SETTING) {
            if (resultCode == 999) {
                name.setText(data.getStringExtra("ten"));
            }
        }
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            Glide.with(getActivity())
                    .load(imageUri)
                    .into(avatar);
        }
    }
}
