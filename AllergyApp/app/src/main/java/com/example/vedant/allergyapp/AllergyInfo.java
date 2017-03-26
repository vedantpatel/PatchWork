package com.example.vedant.allergyapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllergyInfo extends AppCompatActivity {

    Resources res;
    private ArrayList<String> mainList;
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_info2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pictures shared with your dermatologist!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));

        Intent intent = getIntent();
        int position = intent.getIntExtra("strpos", 0);

        res = getResources();
        String[] Metal_Cosmetics = res.getStringArray(R.array.Metal_Cosmetics);
        String[] Natural_Contact = res.getStringArray(R.array.Natural_Contact);
        String[] Fragrances = res.getStringArray(R.array.Fragrances);/*
        String[] Metals = res.getStringArray(R.array
                .Metals);
        String[] WildPlants = res.getStringArray(R.array.WildPlants);*/

        mainList = new ArrayList<String>();

        mainList.add("NATURAL/CONTACT");
        for (String str : Natural_Contact) {
            mainList.add(str);
        }
        mainList.add("FRAGRANCES");
        for (String str : Fragrances) {
            mainList.add(str);
        }
        mainList.add("METAL/COSMETICS");
        for (String str : Metal_Cosmetics) {
            mainList.add(str);
        }

        mainList.add("INSTRUCTIONS");


        TextView text = (TextView) findViewById(R.id.allergyName);
        text.setText(mainList.get(position));

        ImageView photo = (ImageView) findViewById(R.id.pictureBox);

        if (position == 1) {
            photo.setImageResource(R.mipmap.balsam_peru_mild);
        } else if (position == 10)
        {
            photo.setImageResource(R.mipmap.oakmoss_mild);
        }
    }

}
