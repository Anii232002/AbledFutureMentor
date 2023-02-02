package com.example.abledfuture;

import android.widget.ImageView;

public class UserItem {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private String name,description;
    int img;

    UserItem(String name,String des,int img)
    {
        this.name  = name;
        this.description = des;
        this.img = img;
    }
}
