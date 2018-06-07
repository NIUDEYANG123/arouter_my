package com.guiying.module.news;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.guiying.module.common.base.RouterConfig;

//@Route(path = RouterConfig.pathrepalcenews)
public class TestPathReplaceService implements PathReplaceService {
    @Override
    public String forString(String path) {
        return "/girls/list";
    }

    @Override
    public Uri forUri(Uri uri) {
        return uri;
    }

    @Override
    public void init(Context context) {

    }
}
