package com.fundamental.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvList = findViewById(R.id.lv_list);

        heroAdapter = new HeroAdapter(this);
        lvList.setAdapter(heroAdapter);

    }
}
