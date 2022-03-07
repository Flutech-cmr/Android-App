package com.example.flutech_android_app;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String server_ip="http://164.52.221.158:5050/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        WebView w = (WebView) findViewById(R.id.webview_element);
        w.setWebViewClient(new WebViewClient());
        w.loadUrl(server_ip);
        w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setDisplayZoomControls(false);
        w.getSettings().setAllowFileAccess(true);
        w.getSettings().setGeolocationEnabled(true);
        w.getSettings().setCacheMode(-1);


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView w = (WebView) findViewById(R.id.webview_element);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (w.canGoBack()) {
                        if(w.getUrl().equals(server_ip)){}
                        else {
                            w.goBack();
                        }
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
