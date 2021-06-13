package com.example.android.web_viewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView wvl;
    EditText eturl;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wvl = (WebView) findViewById(R.id.webView);
        wvl.setWebViewClient(new MywebView());
        wvl.getSettings().setJavaScriptEnabled(true);
        wvl.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        eturl = (EditText) findViewById(R.id.search);
        wvl.loadUrl("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjl59HQkJXxAhXF7XMBHRIbD4cQPAgI");
    }

    public void Butgo(View view) {
        eturl = (EditText) findViewById(R.id.search);
        LoadURL(eturl.getText().toString());
    }

    public void butback(View view) {
        wvl.goBack();
    }

    public void butforward(View view) {
        wvl.goForward();
    }

    public void LoadURL(String url) {
        this.url = url;
        wvl = (WebView) findViewById(R.id.webView);
        wvl.loadUrl(url);
    }

    private class MywebView extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(url);
            return true;
        }
    }
}
