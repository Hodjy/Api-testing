package com.hod.retrofittest;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hod.retrofittest.retrofitApi.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>
{
    private ArrayList<User> mUsers;
    private View mRootView;

    public UserAdapter(ArrayList<User> iUsers)
    {
        mUsers = iUsers;
    }

    public void setUsers(ArrayList<User> iUsers)
    {
        mUsers = iUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,parent, false);
        return new ViewHolder(mRootView);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull UserAdapter.ViewHolder holder, int position) {
        User user = mUsers.get(position);

        holder.mText.setText(user.getmFirstName());
        loadUrlImage(holder, user.getmAvatarUrl());
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void loadUrlImage(@NotNull ViewHolder holder, String url) {
        Glide.with(holder.itemView.getContext())
                .load(url)
                .into(holder.mImage); // .onLoadFailed(holder.itemView.getContext().getResources()
                        //.getDrawable(R.drawable.ic_launcher_background,
                //holder.itemView.getContext().getTheme()))
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView mImage;
        private TextView mText;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.user_card_image);
            mText = itemView.findViewById(R.id.user_card_name_tv);
        }


    }
}
