package com.example.radva.szakdolgozat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FeedFragment extends Fragment {

    private static boolean isNetworkAvaible;

    private RecyclerView recyclerView;

    final List<Feed> feeds = new ArrayList<>();

    static final int READ_BLOCK_SIZE = 100;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_feed, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);


        Spinner mySpinner = (Spinner) root.findViewById(R.id.spinner);
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

        isNetworkAvaible(getContext());
        initializeData();
        initializeAdapter();

    }

    public static boolean isNetworkAvaible() {
        return isNetworkAvaible;
    }

    public static boolean isNetworkAvaible(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return isNetworkAvaible = true;
        }
        return isNetworkAvaible = false;
    }


    public List<Feed> initializeData() {
        GsonBuilder builder = new GsonBuilder();

        builder.serializeNulls();

        final Gson gson = builder.create();

        isNetworkAvaible();

        if (isNetworkAvaible == true) {
            final GraphRequest request = GraphRequest.newGraphPathRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/szte.ttik.inf/posts",
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            JSONObject jsonObject = response.getJSONObject();

                            try {
                                JSONArray data = jsonObject.getJSONArray("data");
                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject post = data.getJSONObject(i);
                                    System.out.println("POST: " + post);
                                    {
                                        try {

                                            String Message = post.toString();

                                            FileOutputStream fileOutputStream = getContext().openFileOutput(Constants.SAVED_FILE_NAME,Context.MODE_APPEND);
                                            fileOutputStream.write(Message.getBytes());
                                            fileOutputStream.close();

                                            System.out.println("Message: " + Message);

                                            File dir = Environment.getExternalStorageDirectory();
                                            String path = dir.getAbsolutePath();

                                            System.out.println("DIR: " + path);


                                        } catch (Exception e) {
                                            Log.e("Exception", "File save failed: " + e.toString());
                                            e.printStackTrace();
                                        }
                                    };

                                    Feed feed = gson.fromJson(post.toString(), Feed.class);

                                    feeds.add(feed);
                                }

                                GraphRequest nextRequest = response.getRequestForPagedResults(GraphResponse.PagingDirection.NEXT);
                                if (nextRequest != null) {
                                    nextRequest.setCallback(this);
                                    nextRequest.executeAsync();
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

        } else if (isNetworkAvaible == false && feeds != null ) {
            System.out.println("FEEDS PROBA letoltve:" + feeds);

            try {
                Gson gsonRead = new Gson();
                FileInputStream fileInputStream = getContext().openFileInput(Constants.SAVED_FILE_NAME);

                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

                Type type = new TypeToken<List<Feed>>(){}.getType();
                List<Feed> feedsRead = gsonRead.fromJson(br, type);

                JSONObject jsonObject = (JSONObject) feedsRead;

                try {
                    JSONArray data = jsonObject.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject post = data.getJSONObject(i);
                        System.out.println("POST: " + post);


                        Feed feed = gson.fromJson(post.toString(), Feed.class);

                        feeds.add(feed);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                Log.e("Exception", "File open failed: " + e.toString());
                e.printStackTrace();
            }

            Toast.makeText(getActivity(), "Internet kapcsolat nélkül lehetséges, hogy a legfrisebb adatok nem tekinthetőek meg!", Toast.LENGTH_SHORT).show();

        } else {
            System.out.println("FEEDS PROBA:" + feeds);
            Toast.makeText(getActivity(), "Internet kapcsolat szűkséges elsőnek az adatok letöltéséhez!", Toast.LENGTH_SHORT).show();
        }
        return feeds;
    }

    private void initializeAdapter() {
        FeedAdapter feedAdapter = new FeedAdapter(feeds);
        recyclerView.setAdapter(feedAdapter);
    }
}