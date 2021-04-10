package com.example.datting.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.datting.R;
import com.example.datting.ui.chat.Adapter.TabChatAdapter;
import com.google.android.material.tabs.TabLayout;

public class ChatFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private com.example.datting.ui.chat.ChatViewModel chatViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chatViewModel =
                ViewModelProviders.of(this).get(com.example.datting.ui.chat.ChatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        FragmentManager fragmentManager = getFragmentManager();
        TabChatAdapter tabChatAdapter = new TabChatAdapter(fragmentManager,2);
        viewPager.setAdapter(tabChatAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void init(View v){
        viewPager= v.findViewById(R.id.viewPage);
        tabLayout= v.findViewById(R.id.tabTab);
    }

}
