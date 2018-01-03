package com.gouda.vivek.checkbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox momObj;
    private CheckBox dadObj;
    private CheckBox broObj;
    private TextView answerObj;
    private Button buttonObj;

    private AlertDialog.Builder altertDialogObj;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonObj = (Button) findViewById(R.id.buttonClick);
        answerObj = (TextView) findViewById(R.id.answerTV);
        momObj = (CheckBox) findViewById(R.id. mom_cb);
        dadObj = (CheckBox) findViewById(R.id.dad_cb);
        broObj = (CheckBox) findViewById(R.id.bro_cb);

        buttonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(momObj.getText().toString() + "staus is : "
                    + momObj.isChecked() + "\n");

                stringBuilder.append(dadObj.getText().toString() + "staus is : "
                        + dadObj.isChecked() + "\n");

                stringBuilder.append(broObj.getText().toString() + "staus is : "
                        + broObj.isChecked() + "\n");

                answerObj.setText(stringBuilder);
            }
        });

        showDialog = (Button) findViewById(R.id.adButton);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //show actual dialog
                altertDialogObj = new AlertDialog.Builder(MainActivity.this);

                //set things up - set a titel
                altertDialogObj.setTitle(getResources().getString(R.string.title));

                //set msg
                altertDialogObj.setMessage(getResources().getString(R.string.message_name));

                //set cancelable
                altertDialogObj.setCancelable(false);

                //set positive button
                altertDialogObj.setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Exit window activity
                                MainActivity.this.finish();
                            }
                        });

                //set negetive button
                altertDialogObj.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                //create actual dialog
                AlertDialog dialog = altertDialogObj.create();

                //show dialog
                dialog.show();
            }
        });
    }
}
