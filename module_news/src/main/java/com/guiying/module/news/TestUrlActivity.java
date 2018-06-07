package com.guiying.module.news;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guiying.module.common.base.BaseActivity;
import com.guiying.module.common.base.RouterConfig;
import com.guiying.module.common.bean.Testobj;

/**
 * 通过schemeActivity跳转过来
 * arouter://m.aliyun.com/news/activity1?name=alex&age=18&boy=true&high=180&obj={"name":"jack","id":"666"}
 */
@Route(path = RouterConfig.URLACTIVITY)
public class TestUrlActivity extends BaseActivity {
    @Autowired
    public String url;
    @Autowired
    public String name;
    @Autowired
    public String high;
    @Autowired
    public int age;
    @Autowired(name = "boy")// 通过name来映射URL中的不同参数
    public boolean girl;
    @Autowired
    Testobj obj;    // 支持解析自定义对象，URL中使用json传递*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        System.out.println(url + name + age + girl + high+obj.toString());
    }
}
