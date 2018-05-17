package com.example.radva.szakdolgozat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class GameFragment extends Fragment {


    public GameFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        // Inflate the layout for this fragment
        final ImageView mezo1 = view.findViewById(R.id.mezo001);
        final ImageView mezo2 = view.findViewById(R.id.mezo002);
        mezo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo1.isActivated()) {
                    mezo1.setActivated(true);
                } else {
                    mezo1.setActivated(false);
                }
            }
        });

        mezo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo2.isActivated()) {
                    mezo2.setActivated(true);
                } else {
                    mezo2.setActivated(false);
                }
            }
        });

        return view;

    }


}
