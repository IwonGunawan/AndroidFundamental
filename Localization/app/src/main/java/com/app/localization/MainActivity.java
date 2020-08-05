package com.app.localization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHello, tvPlural, tvXliff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tv_hello);
        tvPlural = findViewById(R.id.tv_plural);
        tvXliff = findViewById(R.id.tv_xliff);

        String hello = String.format(getResources().getString(R.string.hello_world), "Narenda wicaksono", 3, "Yoza aprilio");
        tvHello.setText(hello);

        String plural = getResources().getQuantityString(R.plurals.numberOfSongsAvailable, 1, 1);
        tvPlural.setText(plural);

        String xliff = getResources().getString(R.string.app_homeurl);
        tvXliff.setText(xliff);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_change_language) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
