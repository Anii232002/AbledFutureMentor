package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Users extends Fragment implements UserAdapter.onClickListner{

 private ArrayList<infoModel> userList;
 private UserAdapter userAdapter;
 private RecyclerView recyclerView;

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





//        userList.add(new UserItem("Raunak Singh","I have a damaged leg ",R.drawable.person1));
//        userList.add(new UserItem("Sahil Rajpal","I am a visually impaired artist ",R.drawable.person2));
//        userList.add(new UserItem("vineet Shinde","I am a visually impaired artist ",R.drawable.person2));
//        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
//        UserAdapter adapter = new UserAdapter(getContext(),userList,Users.this);
//        adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                // Handle the click event
//                startActivity(new Intent(getContext(),AbledInfo.class));
//            }
//        });
//        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        // this will load from end and will show latest post first
        recyclerView.setLayoutManager(layoutManager);

        userList = new ArrayList<>();
        loadUsers();

    }


    private void loadUsers() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("UserInfo");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    infoModel infoModel = ds.getValue(infoModel.class);
                    userList.add(infoModel);
                    userAdapter = new UserAdapter(getContext(),userList,Users.this::onClicked);
                    recyclerView.setAdapter(userAdapter);
                    userAdapter.notifyDataSetChanged();
                }
//                progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled (@NonNull DatabaseError databaseError) {
//                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClicked(int position) {

        Intent intent = new Intent(getActivity(),AbledInfo.class);
        intent.putExtra("name",userList.get(position).getName());
        intent.putExtra("age",userList.get(position).getAge());
        intent.putExtra("gender",userList.get(position).getGender());
        intent.putExtra("email",userList.get(position).getEmail());
        intent.putExtra("location",userList.get(position).getLocation());
        intent.putExtra("skills",userList.get(position).getSkills());
        intent.putExtra("studied",userList.get(position).getStudied());
        intent.putExtra("profile_url",userList.get(position).getProfile_img_link());



        startActivity(intent);



    }
}