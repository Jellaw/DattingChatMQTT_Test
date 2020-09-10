package com.example.datting.ui.chat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datting.ChattingActivity;
import com.example.datting.R;
import com.example.datting.ui.chat.Model.UserChat;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserChatAdapter extends RecyclerView.Adapter<UserChatAdapter.Viewholder> {
    ArrayList<UserChat> userChats;
    Context context;

    public UserChatAdapter(ArrayList<UserChat> userChats, Context context) {
        this.userChats = userChats;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycker_framechat_user_chat, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, int position) {
        holder.tv_name.setText(userChats.get(position).getNameUserChat());
        holder.tv_text.setText(userChats.get(position).getTextUserChat());
        holder.tv_time.setText(userChats.get(position).getTimeUserChat());
        holder.tv_number.setText(userChats.get(position).getNumberUserChat());

        holder.civ_image.setImageResource(userChats.get(position).getImgUserChat());
        holder.cim_chamXanh.setImageResource(userChats.get(position).getImgChamXanh());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChattingActivity.class);
                holder.itemView.setBackgroundColor(Color.parseColor("#80EDEAEA"));
                context.startActivity(intent);
            }
        });
    }
    public interface OnItemClickedListener {
        void onItemClick(String username);
    }

    @Override
    public int getItemCount() {
        return userChats.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        CircleImageView civ_image, cim_chamXanh;
        TextView tv_name, tv_text, tv_time, tv_number;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            civ_image = itemView.findViewById(R.id.civ_image);
            cim_chamXanh = itemView.findViewById(R.id.cim_chamXanh);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_text = itemView.findViewById(R.id.tv_text);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_number = itemView.findViewById(R.id.tv_number);
        }
    }
}
