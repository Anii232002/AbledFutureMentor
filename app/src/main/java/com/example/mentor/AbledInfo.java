package com.example.mentor;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class AbledInfo extends AppCompatActivity {

    TextView name,age,gender,email,location,skills,studied,interests;
    CircleImageView profile_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abled_info);

        ini();

        Bundle extras = getIntent().getExtras();
        String user_name = extras.getString("name");
        String user_age = extras.getString("age");
        String user_gender = extras.getString("gender");
        String user_email = extras.getString("email");
        String user_location = extras.getString("location");
        String user_skills = extras.getString("skills");
        String user_studied = extras.getString("studied");
        String user_interests = extras.getString("interests");
        String url = extras.getString("profile_url");

        name.setText(user_name);
        age.setText(user_age);
        gender.setText(user_gender);
        email.setText(user_email);
        location.setText(user_location);
        skills.setText(user_skills);
        studied.setText(user_studied);
        interests.setText(user_interests);
        Glide.with(getApplicationContext()).load(url).into(profile_view);
    }

    private void ini() {
        name=findViewById(R.id.abled_name);
        age=findViewById(R.id.abled_age);
        gender=findViewById(R.id.abled_gender);
        email=findViewById(R.id.abled_email);
        location=findViewById(R.id.abled_location);
        skills=findViewById(R.id.abled_skills);
        studied=findViewById(R.id.abled_qualification);
        profile_view=findViewById(R.id.profile_image);
    }

}