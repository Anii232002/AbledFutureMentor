package com.example.abledfuture;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView des;
    private ImageView img;

    public MyViewHolder(@NonNull View itemView, final MyAdapter.OnItemClickListener listener) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        des = itemView.findViewById(R.id.description);
        img = itemView.findViewById(R.id.profile_image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }



    public void bind(UserItem i) {
        name.setText(i.getName());
        des.setText(i.getDescription());
        img.setImageResource(i.img);
    }
}