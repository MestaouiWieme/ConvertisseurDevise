package com.example.convertisseurdevise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double mnt;
    TextView result;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Adding items to list "from"
        Spinner spinnerfr = findViewById(R.id.from);
        ArrayList<String> from = new ArrayList<>();
        from.add("TND");
        from.add("EURO");
        from.add("USD");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, from);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerfr.setAdapter(arrayAdapter);

        //Adding items to list "to"
        Spinner spinnerto = findViewById(R.id.to);
        ArrayList<String> to = new ArrayList<>();
        to.add("EURO");
        to.add("TND");
        to.add("USD");
        ArrayAdapter<String> arrayAdapterto = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, to);
        arrayAdapterto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerto.setAdapter(arrayAdapterto);
        final EditText vl = findViewById(R.id.mont);
        final Button btnConvert = findViewById(R.id.button);
        btnConvert.setOnClickListener(v -> {

            result = findViewById(R.id.result);

            String to1 = spinnerto.getSelectedItem().toString();
            String from1 = spinnerfr.getSelectedItem().toString();
            if(!vl.getText().toString().isEmpty()) {
                String vl1 =vl.getText().toString();
                mnt = Double.parseDouble(vl1);
                switch (to1) {
                    case "TND":
                        switch (from1) {
                            case "TND": {
                                double sum = mnt;
                                String r = "votre montant TND est : " + sum;
                                result.setText(r);
                                break;
                            }
                            case "EURO": {
                                double sum = mnt * 3.28;
                                String r = "votre montant TND en Euro  est : " + sum;
                                result.setText(r);
                                break;
                            }
                            case "USD": {
                                double sum = mnt * 3.16;
                                String r = "votre montant TND en USD est : " + sum;
                                result.setText(r);

                                break;
                            }
                        }

                        break;
                    case "EURO":
                        switch (from1) {
                            case "TND": {
                                double sum = mnt * 0.30;
                                String r = "votre montant Euro en TND est : " + sum;
                                result.setText(r);
                                break;
                            }
                            case "EURO": {
                                double sum = mnt;
                                String r = "votre montant de Euro en Euro  est : " + sum;
                                result.setText(r);
                                break;
                            }
                            case "USD": {
                                double sum = mnt * 0.96;
                                String r = "votre montant de Euro en USD est : " + sum;
                                result.setText(r);

                                break;
                            }
                        }

                        break;
                    case "USD":
                        switch (from1) {
                            case "TND": {
                                double sum = mnt * 0.32;
                                String r = "votre montant USD en dinars est : " + sum;
                                result.setText(r);
                                break;
                            }
                            case "EURO": {
                                double sum = mnt * 1.04;
                                String r = "votre montant USD en Euro  est : " + sum;
                                result.setText(r);
                                break;
                            }
                            case "USD": {
                                double sum = mnt;
                                String r = "votre montant en USD est : " + sum;
                                result.setText(r);
                                break;
                            }
                        }
                        break;
                }
            }
            else
            {
                Toast.makeText(MainActivity.this, "Please Enter a Value to Convert..", Toast.LENGTH_SHORT).show();

            }
        });
    }
}