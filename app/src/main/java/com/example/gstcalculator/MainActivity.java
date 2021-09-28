package com.example.gstcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int amount;
    int gstPercent;
    private double total;
    private double gstAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        EditText etGSTAmount = findViewById(R.id.et_outputGST);
        EditText etInput = findViewById(R.id.et_amount);
        EditText etTotal = findViewById(R.id.et_totalAmount);
        Spinner spPercent = findViewById(R.id.sp_percent);


        //GST Percent Spinner
        spPercent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                gstPercent = Integer.parseInt(spPercent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Calculate Button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etInput.getText().toString().isEmpty()){
                    etInput.setError("Cannot be empty");
                    etInput.requestFocus();
                }else {
                    amount = Integer.parseInt(etInput.getText().toString());
                    gstAmount = (gstPercent / 100.0) * amount;
                    total = gstAmount + amount;
                    etGSTAmount.setText("GST Amount: Rs "+Double.toString(gstAmount));
                    etTotal.setText("Total Amount: Rs "+Double.toString(total));
                }
            }
        });
    }
}