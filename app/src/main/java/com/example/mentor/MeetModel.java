package com.example.mentor;

public class MeetModel {

    private String topic, description;
    private String name;
    private String meetCode;


    public String getName() {
        return name;
    }

    public MeetModel(String topic, String description, String name, String meetCode) {
        this.topic = topic;
        this.description = description;
        this.name = name;
        this.meetCode = meetCode;
    }

    public void setName(String meetLink) {
        this.name = meetLink;
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
