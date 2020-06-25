package com.fundamental.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class IntentWithDataActivity extends AppCompatActivity {

    public static final String FULLNAME = "fullname";
    public static final String AGE = "age";
    public static final String DESC = "desc";

    TextView tvFullname, tvAge, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_data);

        String fullname = getIntent().getStringExtra(FULLNAME);
        int age = getIntent().getIntExtra(AGE, 0);
        String desc = getIntent().getStringExtra(DESC);


        tvFullname = findViewById(R.id.tv_fullname);
        tvAge = findViewById(R.id.tv_age);
        tvDesc = findViewById(R.id.tv_desc);


        tvFullname.setText(fullname);
        tvAge.setText(String.valueOf(age));
        tvDesc.setText(desc);
    }
}
