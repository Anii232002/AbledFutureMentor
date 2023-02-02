package com.example.abledfuture;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Users extends Fragment {

 private ArrayList<UserItem> userList;

    public Users() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_users, container, false);
        userList = new ArrayList<>();

        userList.add(new UserItem("Raunak Singh","I have a damaged leg ",R.drawable.person1));
        userList.add(new UserItem("Sahil Rajpal","I am a visually impaired artist ",R.drawable.person2));
        userList.add(new UserItem("vineet Shinde","I am a visually impaired artist ",R.drawable.person2));
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(userList);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle the click event
                startActivity(new Intent(getContext(),AbledInfo.class));
            }
        });
        recyclerView.setAdapter(adapter);
        return v;
    }
}