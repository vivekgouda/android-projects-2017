package com.gouda.vivek.shownextactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMsg;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        showMsg = (TextView) findViewById(R.id.message);
        backButton = (Button) findViewById(R.id.backButton);

        if(extras!=null) {

            String message = extras.getString("message1");
            int myInt = extras.getInt("value");

            showMsg.setText("Message : " + message + " and " + String.valueOf(myInt));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","From SecondActivity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
