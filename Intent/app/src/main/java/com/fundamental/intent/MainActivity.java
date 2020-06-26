package com.fundamental.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 100;

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
                Person person = new Person();
                person.setName("Iwon Gunawan");
                person.setAge(19);
                person.setCity("Bogor");
                person.setEmail("iwongunawan@gmail.com");


                Intent intent2 = new Intent(MainActivity.this, IntentWithObjectActivity.class);
                intent2.putExtra(IntentWithObjectActivity.PERSON, person);
                startActivity(intent2);
                break;

            case R.id.btn_dial_number:
                String number = "08988429390";
                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intent3);
                break;

            case R.id.btn_intent_with_result:
                Intent intent4 = new Intent(MainActivity.this, IntentWithResultActivity.class);
                startActivityForResult(intent4, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQUEST_CODE) {
            if (resultCode == IntentWithResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(IntentWithResultActivity.SELECTED_VALUE, 0);

                Context context = getApplicationContext();
                Toast.makeText(context, "selected value is " + selectedValue, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
