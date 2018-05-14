package com.example.radva.szakdolgozat;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GameFragment extends Fragment {


    public GameFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Button mezo1 = container.findViewById(R.id.mezo001);
        mezo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mezo1.setVisibility(View.GONE);
            }
        });

        return inflater.inflate(R.layout.fragment_game, container, false);
    }


}
