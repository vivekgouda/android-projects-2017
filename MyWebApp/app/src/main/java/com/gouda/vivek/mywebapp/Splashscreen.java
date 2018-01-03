package com.gouda.vivek.mywebapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by vivek on 22/9/17.
 */

public class SplashScreen extends Activity
{
    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 3000; // 3 seconds
    private Handler myhandler;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        myhandler = new Handler();
// run a thread to start the home screen
        myhandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (isWorkingInternetPersent()) {
                    finish();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                } else {

                    setContentView(R.layout.internet);

                }
            }
        }, SPLASH_DURATION);
    }

    public boolean isWorkingInternetPersent() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getBaseContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    //handle back button press
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}

