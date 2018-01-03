package com.gouda.vivek.sharedperfs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enterMsg;
    private Button save;
    private TextView result;
    private SharedPreferences myPerfs;
    private static final String PREFS_NAME = "myPerfsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMsg = (EditText) findViewById(R.id.enterSomthing);
        result = (TextView) findViewById(R.id.megTV);
        save = (Button) findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myPerfs = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = myPerfs.edit();

                editor.putString("message",enterMsg.getText().toString());
                editor.commit();
            }
        });

        //Get data back ie display

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME,0);

        if (preferences.contains("message")) {
            String msg = preferences.getString("message","not found");
            result.setText("Message : "+msg);
        }
    }
}
