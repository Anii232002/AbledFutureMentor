package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mentor.MeetAdapter;
import com.example.mentor.MeetModel;
import com.example.mentor.databinding.FragmentMeetingBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MeetingFragment extends Fragment {

    public MeetingFragment() {
        // Required empty public constructor
    }

    ArrayList<MeetModel> list;
    FirebaseAuth auth;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();
        list.add(new MeetModel("Content writing","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget sodales sem."));
        list.add(new MeetModel("Seminar","Cras fermentum mi est, eu pellentesque elit pellentesque sit amet. "));
        list.add(new MeetModel("Content writing","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget sodales sem."));
        list.add(new MeetModel("Video Editing","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget sodales sem."));
        list.add(new MeetModel("Content writing","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget sodales sem."));
        MeetAdapter adapter = new MeetAdapter(list,binding.recyclerViewMeeting,getContext());
        binding.recyclerViewMeeting.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewMeeting.setAdapter(adapter);

        /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference("meetings");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot s: snapshot.getChildren()){
                    MeetModel infoModel = s.getValue(MeetModel.class);
                    list.add(infoModel);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })*/

        binding.scheduleMeetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ScheduleMeeting.class));
            }
        });

    }

    FragmentMeetingBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMeetingBinding.inflate(getLayoutInflater());


        return binding.getRoot();
    }
}