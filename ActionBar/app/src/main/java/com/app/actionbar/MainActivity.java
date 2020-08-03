package com.app.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new MenuFragment())
                        .addToBackStack(null)
                        .commit();
                return true;

            case R.id.menu_2:
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                return true;

                default:
                    return true;
        }

    }
}
