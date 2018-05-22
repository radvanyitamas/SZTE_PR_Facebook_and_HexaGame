package com.example.radva.szakdolgozat.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.radva.szakdolgozat.Feed;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "feed_db";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(Feed.CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Feed.TABLE_NAME);

        onCreate(db);
    }

    public long insertFeed(String feed_id, String description, String full_picture, String link, String created_time, String story, String message) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Feed.COLUMN_FEED_ID, feed_id);
        values.put(Feed.COLUMN_DESCRIPTION, description);
        values.put(Feed.COLUMN_FULLPICUTRE, full_picture);
        values.put(Feed.COLUMN_LINK, link);
        values.put(Feed.COLUMN_CREATEDTIME, created_time);
        values.put(Feed.COLUMN_STORY, story);
        values.put(Feed.COLUMN_MESSAGE, message);

        long id = db.insert(Feed.TABLE_NAME, null, values);


        return id;
    }

    public Feed getFeed(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Feed.TABLE_NAME, new String[]{Feed.COLUMN_FEED_ID, Feed.COLUMN_DESCRIPTION,
        Feed.COLUMN_FULLPICUTRE, Feed.COLUMN_LINK, Feed.COLUMN_CREATEDTIME, Feed.COLUMN_STORY, Feed.COLUMN_MESSAGE},
                Feed.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

            Feed feeddb = new Feed(
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_FEED_ID)),
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_FULLPICUTRE)),
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_LINK)),
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_CREATEDTIME)),
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_STORY)),
                    cursor.getString(cursor.getColumnIndex(Feed.COLUMN_MESSAGE))
            );

            cursor.close();
            return feeddb;

    }

    public List<Feed> getAllFeeds() {
        List<Feed> feeds = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Feed.TABLE_NAME + " ORDER BY " + Feed.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Feed feeddb = new Feed();
                feeddb.setId(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_FEED_ID)));
                feeddb.setDescription(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_DESCRIPTION)));
                feeddb.setFull_picture(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_FULLPICUTRE)));
                feeddb.setLink(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_LINK)));
                feeddb.setCreated_time(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_CREATEDTIME)));
                feeddb.setStory(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_STORY)));
                feeddb.setMessage(cursor.getString(cursor.getColumnIndex(Feed.COLUMN_MESSAGE)));

                feeds.add(feeddb);
            } while (cursor.moveToNext());
        }

        db.close();
        return feeds;
    }

    public int getFeedsCount() {
        String countQuery = "SELECT * FROM " + Feed.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

}
