package com.fundamental.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class IntentWithObjectActivity extends AppCompatActivity {

    public static final String PERSON = "person";

    TextView tvName, tvAge, tvCity, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_object);

        tvName = findViewById(R.id.tv_name);
        tvAge = findViewById(R.id.tv_age);
        tvCity = findViewById(R.id.tv_city);
        tvEmail = findViewById(R.id.tv_email);

        Person person = getIntent().getParcelableExtra(PERSON);
        tvName.setText(person.getName());
        tvAge.setText(String.valueOf(person.getAge()));
        tvCity.setText(person.getCity());
        tvEmail.setText(person.getEmail());

    }
}
