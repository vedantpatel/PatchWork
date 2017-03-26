package com.example.vedant.allergyapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mainList;
    private ListView lv;
    boolean isFirstViewClick=false;
    boolean isSecondViewClick=false;


    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = (ListView) findViewById(R.id.list);
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
/*
        for (String str : Metals) {
            mainList.add(str);
        }
        for (String str : WildPlants) {
            mainList.add(str);
        }
*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));

// Create the array adapter to bind the array to the listView
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(  this,
                android.R.layout.simple_list_item_1,
                mainList
        );
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AllergyInfo.class);
                intent.putExtra("strpos", position);
                startActivity(intent);
            }
        });
    }


}
