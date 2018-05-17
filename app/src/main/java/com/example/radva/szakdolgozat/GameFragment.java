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
import android.util.Log;
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
        final ImageView mezo001 = view.findViewById(R.id.mezo001);
        final ImageView mezo002 = view.findViewById(R.id.mezo002);
        final ImageView mezo003 = view.findViewById(R.id.mezo003);
        final ImageView mezo004 = view.findViewById(R.id.mezo004);
        final ImageView mezo005 = view.findViewById(R.id.mezo005);
        final ImageView mezo006 = view.findViewById(R.id.mezo006);
        final ImageView mezo007 = view.findViewById(R.id.mezo007);
        final ImageView mezo008 = view.findViewById(R.id.mezo008);
        final ImageView mezo009 = view.findViewById(R.id.mezo009);
        final ImageView mezo010 = view.findViewById(R.id.mezo010);
        final ImageView mezo011 = view.findViewById(R.id.mezo011);
        final ImageView mezo012 = view.findViewById(R.id.mezo012);
        final ImageView mezo013 = view.findViewById(R.id.mezo013);
        final ImageView mezo014 = view.findViewById(R.id.mezo014);
        final ImageView mezo015 = view.findViewById(R.id.mezo015);
        final ImageView mezo016 = view.findViewById(R.id.mezo016);
        final ImageView mezo017 = view.findViewById(R.id.mezo017);
        final ImageView mezo018 = view.findViewById(R.id.mezo018);
        final ImageView mezo019 = view.findViewById(R.id.mezo019);
        final ImageView mezo020 = view.findViewById(R.id.mezo020);
        final ImageView mezo021 = view.findViewById(R.id.mezo021);
        final ImageView mezo022 = view.findViewById(R.id.mezo022);
        final ImageView mezo023 = view.findViewById(R.id.mezo023);
        final ImageView mezo024 = view.findViewById(R.id.mezo024);
        final ImageView mezo025 = view.findViewById(R.id.mezo025);
        final ImageView mezo026 = view.findViewById(R.id.mezo026);
        final ImageView mezo027 = view.findViewById(R.id.mezo027);
        final ImageView mezo028 = view.findViewById(R.id.mezo028);
        final ImageView mezo029 = view.findViewById(R.id.mezo029);
        final ImageView mezo030 = view.findViewById(R.id.mezo030);
        final ImageView mezo031 = view.findViewById(R.id.mezo031);
        final ImageView mezo032 = view.findViewById(R.id.mezo032);
        final ImageView mezo033 = view.findViewById(R.id.mezo033);
        final ImageView mezo034 = view.findViewById(R.id.mezo034);
        final ImageView mezo035 = view.findViewById(R.id.mezo035);
        final ImageView mezo036 = view.findViewById(R.id.mezo036);
        final ImageView mezo037 = view.findViewById(R.id.mezo037);
        final ImageView mezo038 = view.findViewById(R.id.mezo038);
        final ImageView mezo039 = view.findViewById(R.id.mezo039);
        final ImageView mezo040 = view.findViewById(R.id.mezo040);
        final ImageView mezo041 = view.findViewById(R.id.mezo041);
        final ImageView mezo042 = view.findViewById(R.id.mezo042);
        final ImageView mezo043 = view.findViewById(R.id.mezo043);
        final ImageView mezo044 = view.findViewById(R.id.mezo044);
        final ImageView mezo045 = view.findViewById(R.id.mezo045);
        final ImageView mezo046 = view.findViewById(R.id.mezo046);
        final ImageView mezo047 = view.findViewById(R.id.mezo047);
        final ImageView mezo048 = view.findViewById(R.id.mezo048);
        final ImageView mezo049 = view.findViewById(R.id.mezo049);
        final ImageView mezo050 = view.findViewById(R.id.mezo050);
        final ImageView mezo051 = view.findViewById(R.id.mezo051);
        final ImageView mezo052 = view.findViewById(R.id.mezo052);
        final ImageView mezo053 = view.findViewById(R.id.mezo053);
        final ImageView mezo054 = view.findViewById(R.id.mezo054);
        final ImageView mezo055 = view.findViewById(R.id.mezo055);
        final ImageView mezo056 = view.findViewById(R.id.mezo056);
        final ImageView mezo057 = view.findViewById(R.id.mezo057);
        final ImageView mezo058 = view.findViewById(R.id.mezo058);
        final ImageView mezo059 = view.findViewById(R.id.mezo059);
        final ImageView mezo060 = view.findViewById(R.id.mezo060);
        final ImageView mezo061 = view.findViewById(R.id.mezo061);
        final ImageView mezo062 = view.findViewById(R.id.mezo062);
        final ImageView mezo063 = view.findViewById(R.id.mezo063);
        final ImageView mezo064 = view.findViewById(R.id.mezo064);
        final ImageView mezo065 = view.findViewById(R.id.mezo065);
        final ImageView mezo066 = view.findViewById(R.id.mezo066);
        final ImageView mezo067 = view.findViewById(R.id.mezo067);
        final ImageView mezo068 = view.findViewById(R.id.mezo068);
        final ImageView mezo069 = view.findViewById(R.id.mezo069);
        final ImageView mezo070 = view.findViewById(R.id.mezo070);
        final ImageView mezo071 = view.findViewById(R.id.mezo071);
        final ImageView mezo072 = view.findViewById(R.id.mezo072);
        final ImageView mezo073 = view.findViewById(R.id.mezo073);
        final ImageView mezo074 = view.findViewById(R.id.mezo074);
        final ImageView mezo075 = view.findViewById(R.id.mezo075);
        final ImageView mezo076 = view.findViewById(R.id.mezo076);
        final ImageView mezo077 = view.findViewById(R.id.mezo077);
        final ImageView mezo078 = view.findViewById(R.id.mezo078);
        final ImageView mezo079 = view.findViewById(R.id.mezo079);
        final ImageView mezo080 = view.findViewById(R.id.mezo080);
        final ImageView mezo081 = view.findViewById(R.id.mezo081);
        final ImageView mezo082 = view.findViewById(R.id.mezo082);
        final ImageView mezo083 = view.findViewById(R.id.mezo083);
        final ImageView mezo084 = view.findViewById(R.id.mezo084);
        final ImageView mezo085 = view.findViewById(R.id.mezo085);
        final ImageView mezo086 = view.findViewById(R.id.mezo086);
        final ImageView mezo087 = view.findViewById(R.id.mezo087);
        final ImageView mezo088 = view.findViewById(R.id.mezo088);
        final ImageView mezo089 = view.findViewById(R.id.mezo089);
        final ImageView mezo090 = view.findViewById(R.id.mezo090);
        final ImageView mezo091 = view.findViewById(R.id.mezo091);
        final ImageView mezo092 = view.findViewById(R.id.mezo092);
        final ImageView mezo093 = view.findViewById(R.id.mezo093);
        final ImageView mezo094 = view.findViewById(R.id.mezo094);
        final ImageView mezo095 = view.findViewById(R.id.mezo095);
        final ImageView mezo096 = view.findViewById(R.id.mezo096);
        final ImageView mezo097 = view.findViewById(R.id.mezo097);
        final ImageView mezo098 = view.findViewById(R.id.mezo098);
        final ImageView mezo099 = view.findViewById(R.id.mezo099);
        final ImageView mezo100 = view.findViewById(R.id.mezo100);
        final ImageView mezo101 = view.findViewById(R.id.mezo101);
        final ImageView mezo102 = view.findViewById(R.id.mezo102);
        final ImageView mezo103 = view.findViewById(R.id.mezo103);
        final ImageView mezo104 = view.findViewById(R.id.mezo104);
        final ImageView mezo105 = view.findViewById(R.id.mezo105);
        final ImageView mezo106 = view.findViewById(R.id.mezo106);
        final ImageView mezo107 = view.findViewById(R.id.mezo107);
        final ImageView mezo108 = view.findViewById(R.id.mezo108);
        final ImageView mezo109 = view.findViewById(R.id.mezo109);
        final ImageView mezo110 = view.findViewById(R.id.mezo110);
        final ImageView mezo111 = view.findViewById(R.id.mezo111);
        final ImageView mezo112 = view.findViewById(R.id.mezo112);
        final ImageView mezo113 = view.findViewById(R.id.mezo113);
        final ImageView mezo114 = view.findViewById(R.id.mezo114);
        final ImageView mezo115 = view.findViewById(R.id.mezo115);
        final ImageView mezo116 = view.findViewById(R.id.mezo116);
        final ImageView mezo117 = view.findViewById(R.id.mezo117);
        final ImageView mezo118 = view.findViewById(R.id.mezo118);
        final ImageView mezo119 = view.findViewById(R.id.mezo119);
        final ImageView mezo120 = view.findViewById(R.id.mezo120);
        final ImageView mezo121 = view.findViewById(R.id.mezo121);
        final ImageView mezo122 = view.findViewById(R.id.mezo122);
        final ImageView mezo123 = view.findViewById(R.id.mezo123);
        final ImageView mezo124 = view.findViewById(R.id.mezo124);
        final ImageView mezo125 = view.findViewById(R.id.mezo125);
        final ImageView mezo126 = view.findViewById(R.id.mezo126);
        final ImageView mezo127 = view.findViewById(R.id.mezo127);

        mezo001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo001.isActivated()) {
                    mezo001.setActivated(true);
                } else {
                    mezo001.setActivated(false);
                }
            }
        });

        mezo002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo002.isActivated()) {
                    mezo002.setActivated(true);
                } else {
                    mezo002.setActivated(false);
                }
            }
        });

        mezo003.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo003.isActivated()) {
                    mezo003.setActivated(true);
                } else {
                    mezo003.setActivated(false);
                }
            }
        });

        mezo004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo004.isActivated()) {
                    mezo004.setActivated(true);
                } else {
                    mezo004.setActivated(false);
                }
            }
        });

        mezo005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo005.isActivated()) {
                    mezo005.setActivated(true);
                } else {
                    mezo005.setActivated(false);
                }
            }
        });

        mezo006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo006.isActivated()) {
                    mezo006.setActivated(true);
                } else {
                    mezo006.setActivated(false);
                }
            }
        });

        mezo007.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo007.isActivated()) {
                    mezo007.setActivated(true);
                } else {
                    mezo007.setActivated(false);
                }
            }
        });

        mezo008.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo008.isActivated()) {
                    mezo008.setActivated(true);
                } else {
                    mezo008.setActivated(false);
                }
            }
        });

        mezo009.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo009.isActivated()) {
                    mezo009.setActivated(true);
                } else {
                    mezo009.setActivated(false);
                }
            }
        });

        mezo010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo010.isActivated()) {
                    mezo010.setActivated(true);
                } else {
                    mezo010.setActivated(false);
                }
            }
        });

        mezo011.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo011.isActivated()) {
                    mezo011.setActivated(true);
                } else {
                    mezo011.setActivated(false);
                }
            }
        });

        mezo012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo012.isActivated()) {
                    mezo012.setActivated(true);
                } else {
                    mezo012.setActivated(false);
                }
            }
        });

        mezo013.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo013.isActivated()) {
                    mezo013.setActivated(true);
                } else {
                    mezo013.setActivated(false);
                }
            }
        });

        mezo014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo014.isActivated()) {
                    mezo014.setActivated(true);
                } else {
                    mezo014.setActivated(false);
                }
            }
        });

        mezo015.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo015.isActivated()) {
                    mezo015.setActivated(true);
                } else {
                    mezo015.setActivated(false);
                }
            }
        });

        mezo016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo016.isActivated()) {
                    mezo016.setActivated(true);
                } else {
                    mezo016.setActivated(false);
                }
            }
        });

        mezo017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo017.isActivated()) {
                    mezo017.setActivated(true);
                } else {
                    mezo017.setActivated(false);
                }
            }
        });

        mezo018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo018.isActivated()) {
                    mezo018.setActivated(true);
                } else {
                    mezo018.setActivated(false);
                }
            }
        });

        mezo019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo019.isActivated()) {
                    mezo019.setActivated(true);
                } else {
                    mezo019.setActivated(false);
                }
            }
        });

        mezo020.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo020.isActivated()) {
                    mezo020.setActivated(true);
                } else {
                    mezo020.setActivated(false);
                }
            }
        });

        mezo021.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo021.isActivated()) {
                    mezo021.setActivated(true);
                } else {
                    mezo021.setActivated(false);
                }
            }
        });

        mezo022.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo022.isActivated()) {
                    mezo022.setActivated(true);
                } else {
                    mezo022.setActivated(false);
                }
            }
        });

        mezo023.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo023.isActivated()) {
                    mezo023.setActivated(true);
                } else {
                    mezo023.setActivated(false);
                }
            }
        });

        mezo024.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo024.isActivated()) {
                    mezo024.setActivated(true);
                } else {
                    mezo024.setActivated(false);
                }
            }
        });

        mezo025.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo025.isActivated()) {
                    mezo025.setActivated(true);
                } else {
                    mezo025.setActivated(false);
                }
            }
        });

        mezo026.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo026.isActivated()) {
                    mezo026.setActivated(true);
                } else {
                    mezo026.setActivated(false);
                }
            }
        });

        mezo027.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo027.isActivated()) {
                    mezo027.setActivated(true);
                } else {
                    mezo027.setActivated(false);
                }
            }
        });

        mezo028.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo028.isActivated()) {
                    mezo028.setActivated(true);
                } else {
                    mezo028.setActivated(false);
                }
            }
        });

        mezo029.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo029.isActivated()) {
                    mezo029.setActivated(true);
                } else {
                    mezo029.setActivated(false);
                }
            }
        });

        mezo030.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo030.isActivated()) {
                    mezo030.setActivated(true);
                } else {
                    mezo030.setActivated(false);
                }
            }
        });

        mezo031.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo031.isActivated()) {
                    mezo031.setActivated(true);
                } else {
                    mezo031.setActivated(false);
                }
            }
        });

        mezo032.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo032.isActivated()) {
                    mezo032.setActivated(true);
                } else {
                    mezo032.setActivated(false);
                }
            }
        });

        mezo033.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo033.isActivated()) {
                    mezo033.setActivated(true);
                } else {
                    mezo033.setActivated(false);
                }
            }
        });

        mezo034.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo034.isActivated()) {
                    mezo034.setActivated(true);
                } else {
                    mezo034.setActivated(false);
                }
            }
        });

        mezo035.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo035.isActivated()) {
                    mezo035.setActivated(true);
                } else {
                    mezo035.setActivated(false);
                }
            }
        });

        mezo036.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo036.isActivated()) {
                    mezo036.setActivated(true);
                } else {
                    mezo036.setActivated(false);
                }
            }
        });

        mezo037.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo037.isActivated()) {
                    mezo037.setActivated(true);
                } else {
                    mezo037.setActivated(false);
                }
            }
        });

        mezo038.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo038.isActivated()) {
                    mezo038.setActivated(true);
                } else {
                    mezo038.setActivated(false);
                }
            }
        });

        mezo039.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo039.isActivated()) {
                    mezo039.setActivated(true);
                } else {
                    mezo039.setActivated(false);
                }
            }
        });

        mezo040.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo040.isActivated()) {
                    mezo040.setActivated(true);
                } else {
                    mezo040.setActivated(false);
                }
            }
        });

        mezo041.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo041.isActivated()) {
                    mezo041.setActivated(true);
                } else {
                    mezo041.setActivated(false);
                }
            }
        });

        mezo042.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo042.isActivated()) {
                    mezo042.setActivated(true);
                } else {
                    mezo042.setActivated(false);
                }
            }
        });

        mezo043.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo043.isActivated()) {
                    mezo043.setActivated(true);
                } else {
                    mezo043.setActivated(false);
                }
            }
        });

        mezo044.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo044.isActivated()) {
                    mezo044.setActivated(true);
                } else {
                    mezo044.setActivated(false);
                }
            }
        });

        mezo045.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo045.isActivated()) {
                    mezo045.setActivated(true);
                } else {
                    mezo045.setActivated(false);
                }
            }
        });

        mezo046.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo046.isActivated()) {
                    mezo046.setActivated(true);
                } else {
                    mezo046.setActivated(false);
                }
            }
        });

        mezo047.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo047.isActivated()) {
                    mezo047.setActivated(true);
                } else {
                    mezo047.setActivated(false);
                }
            }
        });

        mezo048.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo048.isActivated()) {
                    mezo048.setActivated(true);
                } else {
                    mezo048.setActivated(false);
                }
            }
        });

        mezo049.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo049.isActivated()) {
                    mezo049.setActivated(true);
                } else {
                    mezo049.setActivated(false);
                }
            }
        });

        mezo050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo050.isActivated()) {
                    mezo050.setActivated(true);
                } else {
                    mezo050.setActivated(false);
                }
            }
        });

        mezo051.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo051.isActivated()) {
                    mezo051.setActivated(true);
                } else {
                    mezo051.setActivated(false);
                }
            }
        });

        mezo052.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo052.isActivated()) {
                    mezo052.setActivated(true);
                } else {
                    mezo052.setActivated(false);
                }
            }
        });

        mezo053.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo053.isActivated()) {
                    mezo053.setActivated(true);
                } else {
                    mezo053.setActivated(false);
                }
            }
        });

        mezo054.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo054.isActivated()) {
                    mezo054.setActivated(true);
                } else {
                    mezo054.setActivated(false);
                }
            }
        });

        mezo055.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo055.isActivated()) {
                    mezo055.setActivated(true);
                } else {
                    mezo055.setActivated(false);
                }
            }
        });

        mezo056.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo056.isActivated()) {
                    mezo056.setActivated(true);
                } else {
                    mezo056.setActivated(false);
                }
            }
        });

        mezo057.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo057.isActivated()) {
                    mezo057.setActivated(true);
                } else {
                    mezo057.setActivated(false);
                }
            }
        });

        mezo058.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo058.isActivated()) {
                    mezo058.setActivated(true);
                } else {
                    mezo058.setActivated(false);
                }
            }
        });

        mezo059.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo059.isActivated()) {
                    mezo059.setActivated(true);
                } else {
                    mezo059.setActivated(false);
                }
            }
        });

        mezo060.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo060.isActivated()) {
                    mezo060.setActivated(true);
                } else {
                    mezo060.setActivated(false);
                }
            }
        });

        mezo061.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo061.isActivated()) {
                    mezo061.setActivated(true);
                } else {
                    mezo061.setActivated(false);
                }
            }
        });

        mezo062.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo062.isActivated()) {
                    mezo062.setActivated(true);
                } else {
                    mezo062.setActivated(false);
                }
            }
        });

        mezo063.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo063.isActivated()) {
                    mezo063.setActivated(true);
                } else {
                    mezo063.setActivated(false);
                }
            }
        });

        mezo064.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo064.isActivated()) {
                    mezo064.setActivated(true);
                } else {
                    mezo064.setActivated(false);
                }
            }
        });

        mezo065.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo065.isActivated()) {
                    mezo065.setActivated(true);
                } else {
                    mezo065.setActivated(false);
                }
            }
        });

        mezo066.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo066.isActivated()) {
                    mezo066.setActivated(true);
                } else {
                    mezo066.setActivated(false);
                }
            }
        });

        mezo067.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo067.isActivated()) {
                    mezo067.setActivated(true);
                } else {
                    mezo067.setActivated(false);
                }
            }
        });

        mezo068.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo068.isActivated()) {
                    mezo068.setActivated(true);
                } else {
                    mezo068.setActivated(false);
                }
            }
        });

        mezo069.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo069.isActivated()) {
                    mezo069.setActivated(true);
                } else {
                    mezo069.setActivated(false);
                }
            }
        });

        mezo070.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo070.isActivated()) {
                    mezo070.setActivated(true);
                } else {
                    mezo070.setActivated(false);
                }
            }
        });

        mezo071.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo071.isActivated()) {
                    mezo071.setActivated(true);
                } else {
                    mezo071.setActivated(false);
                }
            }
        });

        mezo072.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo072.isActivated()) {
                    mezo072.setActivated(true);
                } else {
                    mezo072.setActivated(false);
                }
            }
        });

        mezo073.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo073.isActivated()) {
                    mezo073.setActivated(true);
                } else {
                    mezo073.setActivated(false);
                }
            }
        });

        mezo074.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo074.isActivated()) {
                    mezo074.setActivated(true);
                } else {
                    mezo074.setActivated(false);
                }
            }
        });

        mezo075.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo075.isActivated()) {
                    mezo075.setActivated(true);
                } else {
                    mezo075.setActivated(false);
                }
            }
        });

        mezo076.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo076.isActivated()) {
                    mezo076.setActivated(true);
                } else {
                    mezo076.setActivated(false);
                }
            }
        });

        mezo077.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo077.isActivated()) {
                    mezo077.setActivated(true);
                } else {
                    mezo077.setActivated(false);
                }
            }
        });

        mezo078.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo078.isActivated()) {
                    mezo078.setActivated(true);
                } else {
                    mezo078.setActivated(false);
                }
            }
        });

        mezo079.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo079.isActivated()) {
                    mezo079.setActivated(true);
                } else {
                    mezo079.setActivated(false);
                }
            }
        });

        mezo080.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo080.isActivated()) {
                    mezo080.setActivated(true);
                } else {
                    mezo080.setActivated(false);
                }
            }
        });

        mezo081.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo081.isActivated()) {
                    mezo081.setActivated(true);
                } else {
                    mezo081.setActivated(false);
                }
            }
        });

        mezo082.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo082.isActivated()) {
                    mezo082.setActivated(true);
                } else {
                    mezo082.setActivated(false);
                }
            }
        });

        mezo083.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo083.isActivated()) {
                    mezo083.setActivated(true);
                } else {
                    mezo083.setActivated(false);
                }
            }
        });

        mezo084.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo084.isActivated()) {
                    mezo084.setActivated(true);
                } else {
                    mezo084.setActivated(false);
                }
            }
        });

        mezo085.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo085.isActivated()) {
                    mezo085.setActivated(true);
                } else {
                    mezo085.setActivated(false);
                }
            }
        });

        mezo086.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo086.isActivated()) {
                    mezo086.setActivated(true);
                } else {
                    mezo086.setActivated(false);
                }
            }
        });

        mezo087.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo087.isActivated()) {
                    mezo087.setActivated(true);
                } else {
                    mezo087.setActivated(false);
                }
            }
        });

        mezo088.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo088.isActivated()) {
                    mezo088.setActivated(true);
                } else {
                    mezo088.setActivated(false);
                }
            }
        });

        mezo089.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo089.isActivated()) {
                    mezo089.setActivated(true);
                } else {
                    mezo089.setActivated(false);
                }
            }
        });

        mezo090.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo090.isActivated()) {
                    mezo090.setActivated(true);
                } else {
                    mezo090.setActivated(false);
                }
            }
        });

        mezo091.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo091.isActivated()) {
                    mezo091.setActivated(true);
                } else {
                    mezo091.setActivated(false);
                }
            }
        });

        mezo092.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo092.isActivated()) {
                    mezo092.setActivated(true);
                } else {
                    mezo092.setActivated(false);
                }
            }
        });

        mezo093.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo093.isActivated()) {
                    mezo093.setActivated(true);
                } else {
                    mezo093.setActivated(false);
                }
            }
        });

        mezo094.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo094.isActivated()) {
                    mezo094.setActivated(true);
                } else {
                    mezo094.setActivated(false);
                }
            }
        });

        mezo095.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo095.isActivated()) {
                    mezo095.setActivated(true);
                } else {
                    mezo095.setActivated(false);
                }
            }
        });

        mezo096.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo096.isActivated()) {
                    mezo096.setActivated(true);
                } else {
                    mezo096.setActivated(false);
                }
            }
        });

        mezo097.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo097.isActivated()) {
                    mezo097.setActivated(true);
                } else {
                    mezo097.setActivated(false);
                }
            }
        });

        mezo098.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo098.isActivated()) {
                    mezo098.setActivated(true);
                } else {
                    mezo098.setActivated(false);
                }
            }
        });

        mezo099.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo099.isActivated()) {
                    mezo099.setActivated(true);
                } else {
                    mezo099.setActivated(false);
                }
            }
        });

        mezo100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo100.isActivated()) {
                    mezo100.setActivated(true);
                } else {
                    mezo100.setActivated(false);
                }
            }
        });

        mezo101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo101.isActivated()) {
                    mezo101.setActivated(true);
                } else {
                    mezo101.setActivated(false);
                }
            }
        });

        mezo102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo102.isActivated()) {
                    mezo102.setActivated(true);
                } else {
                    mezo102.setActivated(false);
                }
            }
        });

        mezo103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo103.isActivated()) {
                    mezo103.setActivated(true);
                } else {
                    mezo103.setActivated(false);
                }
            }
        });

        mezo104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo104.isActivated()) {
                    mezo104.setActivated(true);
                } else {
                    mezo104.setActivated(false);
                }
            }
        });

        mezo105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo105.isActivated()) {
                    mezo105.setActivated(true);
                } else {
                    mezo105.setActivated(false);
                }
            }
        });

        mezo106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo106.isActivated()) {
                    mezo106.setActivated(true);
                } else {
                    mezo106.setActivated(false);
                }
            }
        });

        mezo107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo107.isActivated()) {
                    mezo107.setActivated(true);
                } else {
                    mezo107.setActivated(false);
                }
            }
        });

        mezo108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo108.isActivated()) {
                    mezo108.setActivated(true);
                } else {
                    mezo108.setActivated(false);
                }
            }
        });

        mezo109.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo109.isActivated()) {
                    mezo109.setActivated(true);
                } else {
                    mezo109.setActivated(false);
                }
            }
        });

        mezo110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo110.isActivated()) {
                    mezo110.setActivated(true);
                } else {
                    mezo110.setActivated(false);
                }
            }
        });

        mezo111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo111.isActivated()) {
                    mezo111.setActivated(true);
                } else {
                    mezo111.setActivated(false);
                }
            }
        });

        mezo112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo112.isActivated()) {
                    mezo112.setActivated(true);
                } else {
                    mezo112.setActivated(false);
                }
            }
        });

        mezo113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo113.isActivated()) {
                    mezo113.setActivated(true);
                } else {
                    mezo113.setActivated(false);
                }
            }
        });

        mezo114.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo114.isActivated()) {
                    mezo114.setActivated(true);
                } else {
                    mezo114.setActivated(false);
                }
            }
        });

        mezo115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo115.isActivated()) {
                    mezo115.setActivated(true);
                } else {
                    mezo115.setActivated(false);
                }
            }
        });

        mezo116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo116.isActivated()) {
                    mezo116.setActivated(true);
                } else {
                    mezo116.setActivated(false);
                }
            }
        });

        mezo117.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo117.isActivated()) {
                    mezo117.setActivated(true);
                } else {
                    mezo117.setActivated(false);
                }
            }
        });

        mezo118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo118.isActivated()) {
                    mezo118.setActivated(true);
                } else {
                    mezo118.setActivated(false);
                }
            }
        });

        mezo119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo119.isActivated()) {
                    mezo119.setActivated(true);
                } else {
                    mezo119.setActivated(false);
                }
            }
        });

        mezo120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo120.isActivated()) {
                    mezo120.setActivated(true);
                } else {
                    mezo120.setActivated(false);
                }
            }
        });

        mezo121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo121.isActivated()) {
                    mezo121.setActivated(true);
                } else {
                    mezo121.setActivated(false);
                }
            }
        });

        mezo122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo122.isActivated()) {
                    mezo122.setActivated(true);
                } else {
                    mezo122.setActivated(false);
                }
            }
        });

        mezo123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo123.isActivated()) {
                    mezo123.setActivated(true);
                } else {
                    mezo123.setActivated(false);
                }
            }
        });

        mezo124.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo124.isActivated()) {
                    mezo124.setActivated(true);
                } else {
                    mezo124.setActivated(false);
                }
            }
        });

        mezo125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo125.isActivated()) {
                    mezo125.setActivated(true);
                } else {
                    mezo125.setActivated(false);
                }
            }
        });

        mezo126.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo126.isActivated()) {
                    mezo126.setActivated(true);
                } else {
                    mezo126.setActivated(false);
                }
            }
        });

        mezo127.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mezo127.isActivated()) {
                    mezo127.setActivated(true);
                } else {
                    mezo127.setActivated(false);
                }
            }
        });

        return view;

    }


}
