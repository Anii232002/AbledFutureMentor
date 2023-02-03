package com.example.mentor;

public class MeetModel {

    private String topic, description;
    private String meetLink;
    private String meetCode;
    private String profileUrl;


    public String getMeetLink() {
        return meetLink;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public void setMeetLink(String meetLink) {
        this.meetLink = meetLink;
    }

    public String getMeetCode() {
        return meetCode;
    }

    public void setMeetCode(String meetCode) {
        this.meetCode = meetCode;
    }

    public MeetModel(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
