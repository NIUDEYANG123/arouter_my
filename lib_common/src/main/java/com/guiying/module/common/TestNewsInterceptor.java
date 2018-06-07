package com.guiying.module.common;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.guiying.module.common.base.RouterConfig;
import com.guiying.module.common.utils.ToastUtils;

/**
 * 只有定义在组件中才有效，放在libcommon中无效？
 */
@Interceptor(priority = 1, name = "news")
public class TestNewsInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        //postcard.getExtra()可以更具这个值判断需不需要拦截或者getGroup
        System.out.println("TestNewsInterceptor拦截器"+postcard.getGroup()+postcard.getPath()+postcard.getExtra());
        callback.onContinue(postcard);

    }

    @Override
    public void init(Context context) {
        System.out.println("TestNewsInterceptor拦截器被初始化");
    }
}
