package com.guiying.module.girls;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.guiying.module.common.base.RouterConfig;
import com.guiying.module.common.utils.ToastUtils;

//@Interceptor(priority = 2, name = "news")不用这个拦截器
public class TestGirlsInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getPath().equals(RouterConfig.GILRSACTIVITY)) {
            ToastUtils.showShortToast("TestGirlsInterceptor拦截器");
            callback.onContinue(postcard);
        } else {
            callback.onInterrupt(new RuntimeException("用户名不对哦"));
        }
    }

    @Override
    public void init(Context context) {
        System.out.println("TestGirlsInterceptor拦截器被初始化");
    }
}
