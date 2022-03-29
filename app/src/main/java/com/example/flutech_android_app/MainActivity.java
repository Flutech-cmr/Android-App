package com.example.flutech_android_app;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String server_ip="https://comfytronics.in/";
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
        w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


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
