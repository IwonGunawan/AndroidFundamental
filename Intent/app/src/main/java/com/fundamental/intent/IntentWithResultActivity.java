package com.fundamental.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class IntentWithResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SELECTED_VALUE = "selected_value";
    public static final int RESULT_CODE = 101;

    Button btnChosen;
    RadioGroup rgNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_result);

        btnChosen = findViewById(R.id.btn_chosen);
        rgNumber = findViewById(R.id.rg_number);

        btnChosen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_chosen) {
            if (rgNumber.getCheckedRadioButtonId() != 0) {

                int value = 0;
                switch (rgNumber.getCheckedRadioButtonId()) {
                    case R.id.rb_50:
                        value = 50;
                        break;

                    case R.id.rb_100:
                        value = 100;
                        break;

                    case R.id.rb_150:
                        value = 150;
                        break;

                    case R.id.rb_200:
                        value = 200;
                        break;
                }

                Intent intent = new Intent();
                intent.putExtra(SELECTED_VALUE, value);
                setResult(RESULT_CODE, intent);
                finish();
            }
        }
    }
}
