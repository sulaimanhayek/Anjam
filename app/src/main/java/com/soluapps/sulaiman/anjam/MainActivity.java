package com.soluapps.sulaiman.anjam;

import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    WebView web1;
    ProgressBar progbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText mText = (EditText) findViewById(R.id.text);
        Button mbtn9 = (Button) findViewById(R.id.btn9);
        Button mbtn12 = (Button) findViewById(R.id.btn12);
        web1 = (WebView) findViewById(R.id.webView1);
        progbar = (ProgressBar)findViewById(R.id.progressBar1);



        mbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Address = "https://anjam.azmoonakan.org/poli9.aspx?code=" + mText.getText().toString();
                WebSettings webSetting = web1.getSettings();
                webSetting.setBuiltInZoomControls(true);
                webSetting.setJavaScriptEnabled(true);

                web1.setWebViewClient(new WebViewClient());

                web1.loadUrl(Address);

            }
        });

    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            progbar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            progbar.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web1.canGoBack()) {
            web1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}