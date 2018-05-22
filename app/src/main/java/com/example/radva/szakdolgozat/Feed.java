package com.example.radva.szakdolgozat;

public class Feed{

    String id;
    String description;
    String full_picture;
    String link;
    String created_time;
    String story;
    String message;

    public static final String TABLE_NAME = "feeds";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FEED_ID = "feed_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_FULLPICUTRE = "full_picture";
    public static final String COLUMN_LINK = "link";
    public static final String COLUMN_CREATEDTIME = "created_time";
    public static final String COLUMN_STORY = "story";
    public static final String COLUMN_MESSAGE = "message";

    public final static String CREATE_TABLE =  "CREATE TABLE " + TABLE_NAME + "(" +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_FEED_ID + " TEXT"
            + COLUMN_DESCRIPTION + " TEXT,"
            + COLUMN_FULLPICUTRE + " TEXT,"
            + COLUMN_LINK + " TEXT,"
            + COLUMN_CREATEDTIME + " TEXT,"
            + COLUMN_STORY + " TEXT,"
            + COLUMN_MESSAGE + " TEXT"
            + ")";


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
