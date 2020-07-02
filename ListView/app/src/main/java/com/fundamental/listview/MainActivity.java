package com.fundamental.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

//    1. ArrayAdapter
//    private String[] listName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patimura","R A Kartini","Sukarno"};
//    ListView lvList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        lvList = findViewById(R.id.lv_list);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                                                            android.R.layout.simple_list_item_1,
//                                                            android.R.id.text1,
//                                                            listName);
//        lvList.setAdapter(adapter);
//
//    }

//  2. BaseAdapter

    private HeroAdapter heroAdapter;

    ListView lvList;
    private String[] dataName;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvList = findViewById(R.id.lv_list);

        heroAdapter = new HeroAdapter(this);
        lvList.setAdapter(heroAdapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        prepare();
        addItem();
    }

    public void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        Log.d(TAG, "prepare: " + Arrays.toString(dataName));
    }

    public void addItem() {
        if (dataName.length > 0) {
            heroes = new ArrayList<>();

            for (int i=0; i < dataName.length; i++) {
                Hero hero = new Hero();
                hero.setName(dataName[i]);
                hero.setDescription(dataDesc[i]);
                hero.setphoto(dataPhoto.getResourceId(i, -1));
                heroes.add(hero);
            }

            heroAdapter.setHeroes(heroes);
        }
    }
}
