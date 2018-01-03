package com.gouda.vivek.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextObj;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView seekpercent;
    private TextView resultTip;
    private int tipPercent;
    private float enteredAmount;
    private TextView finalbill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextObj = (EditText) findViewById(R.id.billPercentageId);
        seekBar = (SeekBar) findViewById(R.id.seekBarForTip);
        calculateButton = (Button) findViewById(R.id.caluculateButton);
        seekpercent = (TextView) findViewById(R.id.percentageTV);
        resultTip = (TextView) findViewById(R.id.resultTV);
        finalbill = (TextView) findViewById(R.id.finalBill);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekpercent.setText(String.valueOf(seekBar.getProgress())+"%  ");
                resultTip.setText("");
                finalbill.setText("");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipPercent = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();
    }

    public void calculate(){
        float result = 0.0f;
        if (!editTextObj.getText().toString().equals("")){
            enteredAmount = Float.parseFloat(editTextObj.getText().toString());
            result = (enteredAmount * tipPercent)/100;
            resultTip.setText("Your tip will be : " + String.valueOf(result));
            finalbill.setText("Total Bill : " + String.valueOf(result+enteredAmount));

        }else {
            Toast.makeText(MainActivity.this,"Please enter bill amount !",Toast.LENGTH_LONG).show();
        }
    }
}
