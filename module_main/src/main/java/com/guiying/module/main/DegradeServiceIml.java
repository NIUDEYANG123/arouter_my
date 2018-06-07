package com.guiying.module.main;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.guiying.module.common.base.RouterConfig;

/**
 * 降级策略
 */
@Route(path = RouterConfig.degragemain)
public class DegradeServiceIml implements DegradeService {
    @Override
    public void onLost(Context context, Postcard postcard) {
        System.out.println("找不到路径"+postcard.getPath());
    }

    @Override
    public void init(Context context) {

    }
}
