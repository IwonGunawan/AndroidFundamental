package com.fundamental.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIntent, btnIntentData, btnIntentObject, btnDialNumber, btnIntentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntent = findViewById(R.id.btn_intent);
        btnIntentData = findViewById(R.id.btn_intent_with_data);
        btnIntentObject = findViewById(R.id.btn_intent_with_object);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnIntentResult = findViewById(R.id.btn_intent_with_result);


        btnIntent.setOnClickListener(this);
        btnIntentData.setOnClickListener(this);
        btnIntentObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnIntentResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_intent:
                Intent intent = new Intent(this, IntentActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_intent_with_data:
                Intent intent1 = new Intent(this, IntentWithDataActivity.class);
                intent1.putExtra(IntentWithDataActivity.FULLNAME, "iwon gunawan");
                intent1.putExtra(IntentWithDataActivity.AGE, 19);
                intent1.putExtra(IntentWithDataActivity.DESC, "this activity intent with data");
                startActivity(intent1);
                break;

            case R.id.btn_intent_with_object:
                break;
            case R.id.btn_dial_number:
                break;
            case R.id.btn_intent_with_result:
                break;
        }
    }
}
