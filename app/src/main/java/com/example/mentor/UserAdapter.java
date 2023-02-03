package com.example.mentor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyHolder> {

    Context context;
    List<infoModel> userList;
    private onClickListner mOnClickListner;


    public UserAdapter(Context context, List<infoModel> userList, onClickListner onClickListner) {
        this.context = context;
        this.userList = userList;
        this.mOnClickListner = onClickListner;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new MyHolder(view, mOnClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyHolder holder, int position) {

//        String name = userList.get(position).getName();
//        String description = userList.get(position).getpDescription();
        String image = userList.get(position).getProfile_img_link();

        holder.userName.setText(userList.get(position).getName());
//        holder.postDescription.setText (description);

        holder.userImg.setImageDrawable(null);
        Glide.with(context).load(image).into(holder.userImg);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView userImg;
        TextView userName;
        onClickListner mOnClickListner;

        public MyHolder(@NonNull View itemView, onClickListner onClickListner) {
            super(itemView);

            userImg = itemView. findViewById(R.id.profile_image);
            userName = itemView. findViewById(R.id.userName);
//            postDescription = itemView.findViewById(R.id.postDescription);

            mOnClickListner = onClickListner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickListner.onClicked(getAdapterPosition());
        }
    }

    public interface onClickListner {
        void onClicked(int position);
    }

}
