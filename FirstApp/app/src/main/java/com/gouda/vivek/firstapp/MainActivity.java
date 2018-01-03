package com.gouda.vivek.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonObj;
    private TextView textViewObj;
    private EditText editTextObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonObj = (Button) findViewById(R.id.myButton);

        textViewObj = (TextView) findViewById(R.id.myTextView);

        editTextObj = (EditText) findViewById(R.id.editText);

        //change the text of button

        buttonObj.setText(R.string.button_name);

        buttonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String displayTxt;

                displayTxt = editTextObj.getText().toString();
                textViewObj.setVisibility(View.VISIBLE);
                textViewObj.setText(displayTxt);
            }
        });

    }
//This is possible in another way shown above
//    public void  showMe(View view){
//        textViewObj.setVisibility(View.VISIBLE);
//        textViewObj.setText(R.string.show_text);
//    }
}
