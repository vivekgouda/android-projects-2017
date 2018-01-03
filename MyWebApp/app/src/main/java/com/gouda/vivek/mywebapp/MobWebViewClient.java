package com.gouda.vivek.mywebapp;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by vivek on 22/9/17.
 */

public class MobWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if(Uri.parse(url).getHost().endsWith("www.uandblog.com")){
            return false;
        }

        Intent in = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        view.getContext().startActivity(in);
        return true;
    }
}