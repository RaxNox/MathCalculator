package com.example.razz.mathcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PercentageActivity extends AppCompatActivity {

    TextView totalTxt;
    EditText percentageTxt;
    EditText ValueTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage);

        totalTxt = (TextView) findViewById(R.id.totalTxt);
        percentageTxt = (EditText) findViewById(R.id.PercentageTxt);
        ValueTxt = (EditText) findViewById(R.id.ValueTxt);

        Button CalcBtn = (Button) findViewById(R.id.CalcBtn);

        // Set up a click Listner to the Button.
        CalcBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                float percentage = Float.parseFloat(percentageTxt.getText().toString());
                float dec = percentage / 100;
                float total = dec * Float.parseFloat(ValueTxt.getText().toString());
                totalTxt.setText(Float.toString(total));
            }
        });

    }
}
