package com.app.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;
    private ArrayList<Hero> list = new ArrayList<>();
    private String title = "List Mode";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.rv_heroes);
        rvHero.setHasFixedSize(true);

        list.addAll(getList());
        showRecyclerList();
        setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedItem) {
        switch (selectedItem){
            case R.id.action_list:
                title = "List Mode";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Grid Mode";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                showRecyclerCardview();
                break;
        }

        setTitle(title);
    }

    private void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private ArrayList<Hero> getList() {
        String[] dataName   = getResources().getStringArray(R.array.data_name);
        String[] dataDesc   = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto  = getResources().obtainTypedArray(R.array.data_photo);

        ArrayList<Hero> listHero = new ArrayList<>();
        for (int i=0; i < dataName.length; i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDesc[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(hero);
        }

        return listHero;
    }

    private void showRecyclerList() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvHero.setAdapter(listAdapter);

        listAdapter.setOnItemClickCallback(new ListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Toast.makeText(MainActivity.this, "list: " + data.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerGrid(){
        rvHero.setLayoutManager(new GridLayoutManager(this, 2));
        GridAdapter gridAdapter = new GridAdapter(list);
        rvHero.setAdapter(gridAdapter);

        gridAdapter.setOnItemClickCallback(new GridAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Toast.makeText(MainActivity.this, "card: " + data.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerCardview() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        CardviewAdapter cardviewAdapter = new CardviewAdapter(list);
        rvHero.setAdapter(cardviewAdapter);

        cardviewAdapter.setOnItemClickCallback(new CardviewAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Toast.makeText(MainActivity.this, "cardview: " + data.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClicked2(Hero data, String string) {
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
