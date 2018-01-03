package com.gouda.vivek.radiobutton;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.gouda.vivek.radiobutton.R.id.seekBar;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupOBj;
    private RadioButton radioButtonOBj;
    private SeekBar seekBarObj;
    private TextView resultTextViewObj;
    private TextView toggleResultObj;
    private ToggleButton toggleButtonOBj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupOBj = (RadioGroup) findViewById(R.id.radioButtonGroup);
        seekBarObj = (SeekBar) findViewById(seekBar);
        resultTextViewObj = (TextView) findViewById(R.id.result_tv);
        toggleButtonOBj = (ToggleButton) findViewById(R.id.toggleButton);
        toggleResultObj = (TextView) findViewById(R.id.toggleTV);

        radioGroupOBj.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButtonOBj = (RadioButton) findViewById(checkedId);

                switch (radioButtonOBj.getId()){
                    case R.id.RadioButtonYes :
                        if(radioButtonOBj.isChecked()){
                            Log.d("Button1","YES !!");
                        }
                        break;
                    case R.id.RadioButtonNo :
                        if(radioButtonOBj.isChecked()){
                            Log.d("Button2","No !!");
                        }
                        break;
                    case R.id.RadioButtonMaybe :
                        if(radioButtonOBj.isChecked()){
                            Log.d("Button3","Maybe !!");
                        }
                        break;

                }
            }
        });

        resultTextViewObj.setText("Pain Level : 0/10");
        seekBarObj.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SeekBar","OnProgessChanged");
                resultTextViewObj.setTextColor(Color.GRAY);
                resultTextViewObj.setText("Pain Level : "+ seekBar.getProgress() + " / " +
                seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SeekBar","onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("SeekBar","onStartTrackingTouch");
                if(seekBar.getProgress() >= 70){
                    resultTextViewObj.setTextColor(Color.RED);
                }
            }
        });

        toggleButtonOBj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    toggleResultObj.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                }else {
                    toggleResultObj.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
