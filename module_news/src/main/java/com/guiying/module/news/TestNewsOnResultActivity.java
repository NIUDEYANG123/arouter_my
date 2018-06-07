package com.guiying.module.news;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.common.base.BaseActivity;
import com.guiying.module.common.base.RouterConfig;

@Route(path = RouterConfig.TESTONRESULTACTIVITY)
public class TestNewsOnResultActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onresult);
        findViewById(R.id.tv_finish).setOnClickListener(v -> {
            setResult(100);
            finish();
        });
    }
}
