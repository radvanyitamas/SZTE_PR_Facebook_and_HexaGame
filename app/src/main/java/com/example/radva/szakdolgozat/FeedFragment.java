package com.example.radva.szakdolgozat;

import android.app.NotificationManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FeedFragment extends Fragment {

    private boolean isNetworkAvaible;

    private RecyclerView recyclerView;

    final List<Feed> feeds = new ArrayList<>();

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

        Spinner mySpinner = root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.selectFeedType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

                            System.out.println("jsonObject = " + jsonObject);

                            try {
                                feeds.clear();
                                JSONArray data = jsonObject.getJSONArray("data");
                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject post = data.getJSONObject(i);
                                    System.out.println("POST: " + post);

                                    Feed feed = gson.fromJson(post.toString(), Feed.class);

                                    feeds.add(feed);
                                }

                                GraphRequest nextRequest = response.getRequestForPagedResults(GraphResponse.PagingDirection.NEXT);
                                if (nextRequest != null) {
                                    nextRequest.setCallback(this);
                                    nextRequest.executeAsync();
                                } else {
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
            System.out.println("FEEDS PROBA:" + feeds);
            Toast.makeText(getActivity(), "Internet kapcsolat szűkséges elsőnek az adatok letöltéséhez!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ttik_prof_pic)
                        .setContentTitle("Adatok frissítve")
                        .setContentText("SZTE TTIK Informatika Intézet");
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

    private void initializeAdapter() {
        feedAdapter = new FeedAdapter(feeds);
        recyclerView.setAdapter(feedAdapter);
    }
}