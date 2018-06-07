package com.guiying.module.main;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.common.base.BaseActivity;
@Route(path = "/main/webview",extras = 1000000000)
public class HtmlActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView = findViewById(R.id.web);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
