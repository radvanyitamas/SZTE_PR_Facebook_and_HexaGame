package com.example.radva.szakdolgozat;

public class Feed{

    String id;
    String description;
    String full_picture;
    String link;
    String created_time;
    String story;
    String message;


    public Feed(String id, String description, String fullPicture, String link, String createdTime, String story, String message) {
        this.id = id;
        this.description = description;
        this.full_picture = fullPicture;
        this.link = link;
        this.created_time = createdTime;
        this.story = story;
        this.message = message;
    }

    public Feed(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_picture() {
        return full_picture;
    }

    public void setFull_picture(String full_picture) {
        this.full_picture = full_picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
