package com.fundamental.unittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MainViewModel mainViewModel;

    EditText etLength, etWidth, etHeight;
    Button btnSave, btnVolume, btnCircumference, btnSurfaceArea;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());
        etLength = findViewById(R.id.et_length);
        etWidth = findViewById(R.id.et_width);
        etHeight = findViewById(R.id.et_height);
        btnSave = findViewById(R.id.btn_save);
        btnVolume = findViewById(R.id.btn_calculate_volume);
        btnCircumference = findViewById(R.id.btn_calculate_circumreference);
        btnSurfaceArea = findViewById(R.id.btn_calculate_surface_area);
        tvResult = findViewById(R.id.tv_result);

        btnSave.setOnClickListener(this);
        btnVolume.setOnClickListener(this);
        btnCircumference.setOnClickListener(this);
        btnSurfaceArea.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String length = etLength.getText().toString().trim();
        String width = etWidth.getText().toString().trim();
        String height = etHeight.getText().toString().trim();

        Double l = 0.0;
        Double w = 0.0;
        Double h = 0.0;

        if (TextUtils.isEmpty(length)) {
            etLength.setError("please fill length inputbox");
        }
        else if (TextUtils.isEmpty(width)){
            etWidth.setError("please fill width inputbox");
        }
        else if (TextUtils.isEmpty(height)){
            etHeight.setError("please fill height inputbox");
        }
        else {
            l = Double.parseDouble(length);
            w = Double.parseDouble(width);
            h = Double.parseDouble(height);
        }


        switch (view.getId()){
            case R.id.btn_save:
                mainViewModel.save(l, w, h);
                Log.d("aloo", "onClick: save");
                visible();
                break;

            case R.id.btn_calculate_volume:
                double volume = mainViewModel.getVolume();
                tvResult.setText(String.valueOf(volume));
                gone();
                break;

            case R.id.btn_calculate_circumreference:
                double circumference = mainViewModel.getCircumference();
                tvResult.setText(String.valueOf(circumference));
                gone();
                break;

            case R.id.btn_calculate_surface_area:
                double surfacearea = mainViewModel.getSurfaceArea();
                tvResult.setText(String.valueOf(surfacearea));
                gone();
                break;
        }
    }

    public void visible() {
        btnSave.setVisibility(View.GONE);
        btnVolume.setVisibility(View.VISIBLE);
        btnCircumference.setVisibility(View.VISIBLE);
        btnSurfaceArea.setVisibility(View.VISIBLE);
    }

    void gone() {
        btnSave.setVisibility(View.VISIBLE);
        btnVolume.setVisibility(View.GONE);
        btnCircumference.setVisibility(View.GONE);
        btnSurfaceArea.setVisibility(View.GONE);
    }
}
