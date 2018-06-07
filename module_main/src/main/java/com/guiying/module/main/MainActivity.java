package com.guiying.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guiying.module.common.base.BaseActivity;
import com.guiying.module.common.base.RouterConfig;
import com.guiying.module.common.base.ViewManager;
import com.guiying.module.common.bean.TestNewsBean;
import com.guiying.module.common.utils.RxBusHelper;
import com.guiying.module.common.utils.ToastUtils;
import com.guiying.module.news.TestHelloService;


/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/7/1 13:13
 * @version V1.2.0
 * @name MainActivity
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
   @Autowired
   TestHelloService helloService;
    @Autowired(name = RouterConfig.HELLOSERVICE)
    TestHelloService helloService2;

    TestHelloService helloService3;

    TestHelloService helloService4;

    private long mExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.news_button).setOnClickListener(this);
        findViewById(R.id.girls_button).setOnClickListener(this);
        findViewById(R.id.fragment_button).setOnClickListener(this);
        findViewById(R.id.on_result_button).setOnClickListener(this);
        findViewById(R.id.web_button).setOnClickListener(this);
        findViewById(R.id.test_service).setOnClickListener(this);
        testRxBus();

    }

    private void testRxBus() {
        RxBusHelper.doOnChildThread(String.class, new RxBusHelper.OnEventListener<String>() {
            @Override
            public void onEvent(String s) {
                System.out.println(tag+"Rxbustest"+s);
            }

            @Override
            public void onError(RxBusHelper.ErrorBean errorBean) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        // 使用绿色通道(跳过所有的拦截器)
        //ARouter.getInstance().build("/news.center").greenChannel().navigation();
        if (view.getId() == R.id.news_button) {
            //跳转到NewsCenterActivity
            //ARouter.getInstance().build("/news/center").navigation();
            TestNewsBean testNewsBean = new TestNewsBean("va1", "va2");
            ARouter.getInstance().build("/news/center").withParcelable("entity", testNewsBean).withBoolean("state", false)
                    .withString("result", "123456").navigation();
        } else if (view.getId() == R.id.girls_button) {
            //跳转到GirlsActivity
            ARouter.getInstance().build(RouterConfig.boymain).navigation();
        } else if (view.getId() == R.id.fragment_button) {
            startActivity(new Intent(this, BottomNavigationActivity.class));
        } else if (view.getId() == R.id.on_result_button) {
            ARouter.getInstance().build(RouterConfig.TESTONRESULTACTIVITY).navigation(this, 100);
        } else if (view.getId() == R.id.web_button) {
            ARouter.getInstance().build("/main/webview")
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation();/*navigation(this, new NavigationCallback() {
                        @Override
                        public void onFound(Postcard postcard) {
                            System.out.println("找到activity");
                        }

                        @Override
                        public void onLost(Postcard postcard) {
                            System.out.println("找不到activity");
                        }

                        @Override
                        public void onArrival(Postcard postcard) {
                            System.out.println("打开activity");
                        }

                        @Override
                        public void onInterrupt(Postcard postcard) {
                            System.out.println("拦截activity");
                        }
                    });*/
        } else if (view.getId() == R.id.test_service) {
            //testService();
        }
    }

    private void testService() {
        ARouter.getInstance().inject(MainActivity.this);
        System.out.println(helloService.sayHello("hello1"));
        System.out.println(helloService.sayHello("hello2"));
        helloService3 = ARouter.getInstance().navigation(TestHelloService.class);
        System.out.println(helloService3.sayHello("hello3"));
        helloService4 = (TestHelloService) ARouter.getInstance().build(RouterConfig.HELLOSERVICE).navigation();
        System.out.println(helloService3.sayHello("hello4"));
        TestHelloService tt= (TestHelloService) ARouter.getInstance().build(RouterConfig.HELLOSERVICE).navigation();
        System.out.println(helloService3.sayHello("hello5"));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(getString(R.string.app_exit_hint));
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("requestCode=" + requestCode);
    }
}
