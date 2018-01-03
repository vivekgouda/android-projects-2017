package com.gouda.vivek.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView catObj;
    private ImageView dogObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catObj = (ImageView) findViewById(R.id.catId);
        dogObj = (ImageView) findViewById(R.id.dogId);

        catObj.setOnClickListener(this);
        dogObj.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.catId :
                //go to second activity
                Intent catIntent = new Intent(MainActivity.this,BioActivity.class);
                catIntent.putExtra("name","Jarvis");
                catIntent.putExtra("bio","Great Cat. Loves people and meows a lot !");
                startActivity(catIntent);
                Toast.makeText(this, "Cat Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.dogId :
                //go to second activity
                Intent dogIntent = new Intent(MainActivity.this,BioActivity.class);
                dogIntent.putExtra("name","Dufus");
                dogIntent.putExtra("bio","Great Dog. Loves people and barks and eats a lot !");
                startActivity(dogIntent);
                Toast.makeText(this, "Dog Clicked", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
