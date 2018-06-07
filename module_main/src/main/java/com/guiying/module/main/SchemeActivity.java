package com.guiying.module.main;

import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.guiying.module.common.base.BaseActivity;

public class SchemeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        System.out.println("SchemeActivity"+uri.toString());
        ARouter.getInstance().build(uri).navigation();
    }
}
