package com.gouda.vivek.shownextactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button goToNextActivity;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        goToNextActivity = (Button) findViewById(R.id.firstActivityButton);

        goToNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

                intent.putExtra("message1"," Hello World");
                intent.putExtra("value",1234);
                //startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE);
//                startActivity(new Intent(FirstActivity.this,SecondActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra("returnData");

                Toast.makeText(FirstActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
