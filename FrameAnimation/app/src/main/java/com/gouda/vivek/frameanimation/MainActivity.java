package com.gouda.vivek.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable myAnimation;
    private ImageView myImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImg = (ImageView) findViewById(R.id.imgID);
        myImg.setBackgroundResource(R.drawable.animation_my);

        myAnimation = (AnimationDrawable) myImg.getBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        myAnimation.start();

        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                myAnimation.stop();

            }
        },5000);

        return super.onTouchEvent(event);
    }
}
