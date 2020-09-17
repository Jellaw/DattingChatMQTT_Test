package com.example.datting.ui.dashboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datting.R;
import com.example.datting.ui.dashboard.Model.ItemModel;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private List<ItemModel> items;
    private Context context;
    private ClickReaction clickReaction;


    public CardStackAdapter(List<ItemModel> items, Context context, ClickReaction clickReaction) {
        this.items = items;
        this.context = context;
        this.clickReaction = clickReaction;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(items.get(position));
        holder.imgX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                clickReaction.setOnClick(setting);
            }
        });
        holder.imgTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                clickReaction.setOnClick(setting);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image, imgX, imgT, imgTT;
        TextView name, age, address;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            age = itemView.findViewById(R.id.item_age);
            address = itemView.findViewById(R.id.item_city);
            imgX = itemView.findViewById(R.id.cancelBtn);
            imgT = itemView.findViewById(R.id.likeBtn);
            imgTT = itemView.findViewById(R.id.loveBtn);

        }

        void setData(ItemModel data) {
            Glide.with(context)
                    .load(data.getImage())
                    .centerCrop()
                    .into(image);
            Glide.with(context)
                    .load(R.drawable.cancer)
                    .override(100,100)
                    .skipMemoryCache(true)
                    .into(imgX);
            Glide.with(context)
                    .load(R.drawable.imgpsh_fullsize_anim)
                    .override(100,100)
                    .skipMemoryCache(true)
                    .into(imgT);
            Glide.with(context)
                    .load(R.drawable.imgpsh_fullsize)
                    .override(100,100)
                    .skipMemoryCache(true)
                    .into(imgTT);
            name.setText(data.getName());
            age.setText(data.getAge());
            address.setText(data.getAddress());
        }
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
