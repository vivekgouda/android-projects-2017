package com.gouda.vivek.honeydolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText inputMsg;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMsg = (EditText) findViewById(R.id.inputMsg);
        save = (Button) findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inputMsg.getText().toString().equals("")){
                    String msg = inputMsg.getText().toString();
                    WriteToFile(msg);
                }else {
                    //do somting
                }

            }
        });

        try {
            if (ReadFromFile()!=null){
                inputMsg.setText(ReadFromFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void WriteToFile(String msg){

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todolist.txt",
                    Context.MODE_PRIVATE));
            outputStreamWriter.write(msg);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String ReadFromFile() throws IOException {
        String result = "";

        InputStream inputStream = openFileInput("todolist.txt");

        if (inputStream!=null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((tempString=bufferedReader.readLine())!=null){
                
                stringBuilder.append(tempString);
            }

            inputStream.close();
            result = stringBuilder.toString();
        }

        return result;
    }
}
