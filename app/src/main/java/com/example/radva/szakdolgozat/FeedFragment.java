package com.example.radva.szakdolgozat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FeedFragment extends Fragment {

    private boolean isNetworkAvaible;

    private RecyclerView recyclerView;

    final List<Feed> feeds = new ArrayList<>();
    final List<Feed> recentDataList = new ArrayList<>();

    static final int READ_BLOCK_SIZE = 100;
    private FeedAdapter feedAdapter;
    private Context context;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_feed, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        isNetworkAvailable(getContext());
        initializeAdapter();
        initializeData();

    }

    public void isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        isNetworkAvaible = netInfo != null && netInfo.isConnected();
    }


    public void initializeData() {
        context = getContext();
        GsonBuilder builder = new GsonBuilder();

        builder.serializeNulls();

        final Gson gson = builder.create();

        if (isNetworkAvaible) {
            final GraphRequest request = GraphRequest.newGraphPathRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/szte.ttik.inf/posts",
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            JSONObject jsonObject = response.getJSONObject();

                            if(jsonObject == null) {
                                return;
                            }

                            try {

                                SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
                                SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
                                feeds.clear();
                                JSONArray data = jsonObject.getJSONArray("data");
                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject post = data.getJSONObject(i);
                                    System.out.println("POST: " + post);

                                    Feed feed = gson.fromJson(post.toString(), Feed.class);

                                    feeds.add(feed);

                                    String jsonList = gson.toJson(feed);
                                    prefsEditor.putString("Feed", jsonList);
                                    Log.d("FeedShared: ", ""+ jsonList);
                                }


                                prefsEditor.commit();
                                GraphRequest nextRequest = response.getRequestForPagedResults(GraphResponse.PagingDirection.PREVIOUS);
                                if (nextRequest != null) {
                                    nextRequest.setCallback(this);
                                    nextRequest.executeAsync();
                                    feedAdapter.notifyDataSetChanged();
                                    recyclerView.invalidate();
                                } else {
                                    recyclerView.invalidate();
                                    feedAdapter.notifyDataSetChanged();
                                    showNotification();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );


            Bundle parameters = new Bundle();
            parameters.putString("fields", "description,full_picture,link,created_time,story,message,id");
            request.setParameters(parameters);
            request.executeAsync();
        } else {
            get_listFromSharedPrederences(context);
            Toast.makeText(getActivity(), "Internet kapcsolat szűkséges elsőnek az adatok letöltéséhez!" , Toast.LENGTH_SHORT).show();
        }
    }

    private static ArrayList<Feed> get_listFromSharedPrederences(Context context) {
        SharedPreferences appSharedPrefs = context.getSharedPreferences("Feed", Context.MODE_PRIVATE);
        String json = appSharedPrefs.getString("Feed", "");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Feed>>(){}.getType();
        ArrayList<Feed> recentDataList = gson.fromJson(json, type);
        Log.d("NoNetFeed", ""+ recentDataList);

        return recentDataList;
    }

    private void showNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ttik_prof_pic)
                        .setContentTitle("Adatok frissítve")
                        .setContentText("SZTE TTIK Informatika Intézet");

        PendingIntent contentIntent;
        contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

    private void initializeAdapter() {
        if(!isNetworkAvaible && !recentDataList.isEmpty()) {
            feedAdapter = new FeedAdapter(recentDataList);
            recyclerView.setAdapter(feedAdapter);
        } else {
            feedAdapter = new FeedAdapter(feeds);
            recyclerView.setAdapter(feedAdapter);
        }
    }
}