package com.guiying.module.news;

import android.support.annotation.Keep;

import com.alibaba.android.arouter.facade.template.IProvider;
public interface TestHelloService extends IProvider {
    String sayHello(String nme);
}
