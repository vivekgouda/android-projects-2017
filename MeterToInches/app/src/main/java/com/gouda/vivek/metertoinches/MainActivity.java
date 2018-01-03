package com.gouda.vivek.metertoinches;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextObj;
    private Button buttonObj;
    private TextView textViewObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextObj = (EditText) findViewById(R.id.editTextMeter);
        buttonObj = (Button) findViewById(R.id.convertButton);
        textViewObj = (TextView) findViewById(R.id.textViewInches);

        buttonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mutliplier = 39.37;
                double result = 0.0;
                if(editTextObj.getText().toString().equals("")){

                    textViewObj.setText(R.string.error_message);
                    textViewObj.setTextColor(Color.RED);

                }else {

                    double meterValue = Double.parseDouble(editTextObj.getText().toString());
                    result = meterValue*mutliplier;
//                  textViewObj.setText(Double.toString(result) + " inches");
                    textViewObj.setTextColor(Color.DKGRAY);
                    textViewObj.setText(String.format("%.2f",result) + " inches ");

                }
            }
        });
    }
}
