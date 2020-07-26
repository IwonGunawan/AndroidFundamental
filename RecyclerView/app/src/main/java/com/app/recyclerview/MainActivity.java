package com.app.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;
    private ArrayList<Hero> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.rv_heroes);
        rvHero.setHasFixedSize(true);

        list.addAll(getList());
        showRecyclerList();
    }

    private ArrayList<Hero> getList() {
        String[] dataName   = getResources().getStringArray(R.array.data_name);
        String[] dataDesc   = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto  = getResources().getStringArray(R.array.data_photo);

        ArrayList<Hero> listHero = new ArrayList<>();
        for (int i=0; i < dataName.length; i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDesc[i]);
            hero.setPhoto(dataPhoto[i]);
            listHero.add(hero);
        }

        return listHero;
    }

    private void showRecyclerList() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvHero.setAdapter(listAdapter);
    }
}
