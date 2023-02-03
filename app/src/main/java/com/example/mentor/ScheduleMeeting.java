package com.example.mentor;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mentor.databinding.ActivityScheduleMeetingBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.type.DateTime;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Locale;

public class ScheduleMeeting extends AppCompatActivity {


    ActivityScheduleMeetingBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleMeetingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressbar5.setVisibility(View.VISIBLE);
                uploadData();
            }
        });

    }

    private void uploadData() {

//        pd.setMessage("Uploading");
//        pd.show();

          String name = binding.nameOfuser.getText().toString().toLowerCase(Locale.ROOT);
          String topic = binding.topic.getText().toString().toLowerCase(Locale.ROOT);
          String description = binding.topicDescription.getText().toString().toLowerCase(Locale.ROOT);
          String meetcode = "xyzki8edk";



        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("meetings");
        HashMap<String,String> hm = new HashMap<>();
        hm.put("name",name);
        hm.put("topic",topic);
        hm.put("description",description);
        hm.put("meetcode",meetcode);

        databaseReference.child(System.currentTimeMillis()+"").setValue(hm).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                binding.progressbar5.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                binding.progressbar5.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Some Error Occcured", Toast.LENGTH_SHORT).show();
            }
        });


    }


}