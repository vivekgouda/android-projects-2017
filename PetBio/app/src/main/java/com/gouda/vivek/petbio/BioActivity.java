package com.gouda.vivek.petbio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity {

    private ImageView petImageObj;
    private TextView petNameObj;
    private TextView petBioObj;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        petImageObj = (ImageView) findViewById(R.id.petBioImg);
        petNameObj = (TextView) findViewById(R.id.petName);
        petBioObj = (TextView) findViewById(R.id.bioText);

        extras = getIntent().getExtras();

        if(extras!=null) {
            String name = extras.getString("name");
            String bio = extras.getString("bio");

            setUp(name,bio);
        }

    }

    public void setUp(String name,String bio) {

        if(name.equals("Jarvis")) {
            petImageObj.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            petNameObj.setText(name);
            petBioObj.setText(bio);

        }else if(name.equals("Dufus")) {
            petImageObj.setImageDrawable(getResources().getDrawable(R.drawable.dog));
            petNameObj.setText(name);
            petBioObj.setText(bio);
        }

    }
}
