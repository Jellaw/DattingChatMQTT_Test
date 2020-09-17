package com.example.datting.ui.home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.R;
import com.example.datting.ui.dashboard.Model.ItemModel;
import com.example.datting.ui.home.Model.UserDialog;

import java.util.ArrayList;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.ViewHolder> {
        ArrayList<UserDialog> userDialogs;
        Context context;
        Intent i;

public DialogAdapter(ArrayList<UserDialog> userDialog, Context context) {
        this.userDialogs = userDialog;
        this.context = context;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_card_home, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    Glide.with(context)
            .load(userDialogs.get(position).getImage())
            .centerCrop()
            .into(holder.image);

    holder.name.setText(userDialogs.get(position).getName());
    holder.age.setText(userDialogs.get(position).getAge());
    holder.address.setText(userDialogs.get(position).getAddress());
        }

@Override
public int getItemCount() {
        return userDialogs.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name, age, address;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.dialog_image);
        name = itemView.findViewById(R.id.dialog_name);
        age = itemView.findViewById(R.id.dialog_age);
        address = itemView.findViewById(R.id.dialog_city);
    }

    }
}