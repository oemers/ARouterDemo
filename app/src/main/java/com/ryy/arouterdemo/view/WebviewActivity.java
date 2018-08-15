package com.ryy.arouterdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ryy.arouterdemo.R;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/15.
 */
@Route(path = PathUtils.PATH_WEBVIEW_ACTIVITY)
public class WebviewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(getIntent().getStringExtra("url"));
    }
}
