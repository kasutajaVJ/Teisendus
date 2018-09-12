package com.example.vanessajalakas.teisendus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final double FACTOR = 1.609344;
    EditText text;
    RadioButton ml, km;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text.findViewById(R.id.txt_number);
        ml = findViewById(R.id.btn_ml);
        km = findViewById(R.id.btn_km);
    }

    public double toKm(double miles) {
        return miles * FACTOR;
    }

    public double toMl(double kilometers) {
        return kilometers / FACTOR;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            text.setText("");
        } else if (view.getId() == R.id.btn_ok) {
            if (text.getText().length() == 0) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                return;
            }
            double value = Double.parseDouble(text.getText().toString());
            if (ml.isChecked()) text.setText(String.valueOf(toMl(value)));
            else text.setText(String.valueOf(toKm(value)));
        }
    }
}
