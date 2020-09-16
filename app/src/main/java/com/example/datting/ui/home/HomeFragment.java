package com.example.datting.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.datting.R;
import com.example.datting.ui.home.Adapter.CompassAdapter;
import com.example.datting.ui.home.Adapter.CustomItemDecorator;
import com.example.datting.ui.home.Model.UserCompass;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView gv_listUserCompass;
    ArrayList<UserCompass> userCompasses;
    CompassAdapter userCompassAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_compass, container, false);
        init(root);
        return root;
    }

   private void init(View root) {
       gv_listUserCompass = root.findViewById(R.id.gv_listUserCompass);
       userCompasses = new ArrayList<>();

       addUserCompass();

       StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
       manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
       gv_listUserCompass.addItemDecoration(new CustomItemDecorator(getResources().getDimensionPixelSize(R.dimen._16sdp), getResources().getDimensionPixelSize(R.dimen._90sdp)));
       gv_listUserCompass.setLayoutManager(manager);
       gv_listUserCompass.setHasFixedSize(true);
       userCompassAdapter = new CompassAdapter(userCompasses, getContext());
       gv_listUserCompass.setAdapter(userCompassAdapter);
   }
    private void addUserCompass() {
        userCompasses.add(new UserCompass(R.drawable.avt, "1"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "2"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "3"));
        userCompasses.add(new UserCompass(R.drawable.avt, "4"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "5"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "6"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "7"));
        userCompasses.add(new UserCompass(R.drawable.avt, "8"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "9"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "10"));
        userCompasses.add(new UserCompass(R.drawable.avt2, "11"));
        userCompasses.add(new UserCompass(R.drawable.avt, "12"));
    }
}
