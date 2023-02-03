package com.example.mentor;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class infoModel {

    private String aadhar,disability,gender,profile_img_link,name,studied,skills,time,email,uid,age,location;

    public infoModel(String aadhar, String disability, String gender, String profile_img_link, String name, String studied, String skills, String time, String email, String uid, String age, String location) {
        this.aadhar = aadhar;
        this.disability = disability;
        this.gender = gender;
        this.profile_img_link = profile_img_link;
        this.name = name;
        this.studied = studied;
        this.skills = skills;
        this.time = time;
        this.email = email;
        this.uid = uid;
        this.age = age;
        this.location = location;
    }

    public infoModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStudied() {
        return studied;
    }

    public void setStudied(String studied) {
        this.studied = studied;
    }

    public String getProfile_img_link() {
        return profile_img_link;
    }

    public void setProfile_img_link(String profile_img_link) {
        this.profile_img_link = profile_img_link;
    }
}
