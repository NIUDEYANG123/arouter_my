package com.guiying.module.news;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.common.base.RouterConfig;

@Route(path = RouterConfig.HELLOSERVICE)
public class HelloServiceIml implements TestHelloService {
    @Override
    public String sayHello(String nme) {
        return "hello"+nme;
    }

    @Override
    public void init(Context context) {

    }
}
