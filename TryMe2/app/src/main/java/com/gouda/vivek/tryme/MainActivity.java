package com.gouda.vivek.tryme;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View viewObj ;
    private Button buttonObj;
    private int[] colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new int[]{Color.CYAN,Color.BLACK,Color.BLUE,Color.DKGRAY,
                Color.GREEN,Color.GRAY,Color.RED,Color.YELLOW,Color.WHITE};

        viewObj = findViewById(R.id.myView);
        buttonObj = (Button) findViewById(R.id.myButton);

        buttonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorsArrayLength = colors.length;

                Random random = new Random();
                int randomNumber = random.nextInt(colorsArrayLength);

                viewObj.setBackgroundColor(colors[randomNumber]);

                Log.d("Random",String.valueOf(randomNumber));


            }
        });
    }
}
