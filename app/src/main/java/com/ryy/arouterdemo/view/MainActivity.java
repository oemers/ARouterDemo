package com.ryy.arouterdemo.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ryy.arouterdemo.R;
import com.ryy.arouterdemo.constant.Constants;
import com.ryy.arouterdemo.model.TestObj;
import com.ryy.arouterdemo.model.TestParcelable;
import com.ryy.arouterdemo.model.TestSerializable;
import com.ryy.arouterdemo.service.HelloService;
import com.ryy.arouterdemo.service.SingleService;
import com.ryy.arouterdemo.util.PathUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.init:
                // 调试模式不是必须开启，但是为了防止有用户开启了InstantRun，但是
                // 忘了开调试模式，导致无法使用Demo，如果使用了InstantRun，必须在
                // 初始化之前开启调试模式，但是上线前需要关闭，InstantRun仅用于开
                // 发阶段，线上开启调试模式有安全风险，可以使用BuildConfig.DEBUG
                // 来区分环境
                ARouter.openDebug();
                ARouter.openLog();
                ARouter.init(getApplication());
                //ARouterUtils.init(getApplication());
                break;
            case R.id.destroy:
                ARouter.getInstance().destroy();
                //ARouterUtils.destroy();
                break;
            case R.id.normalNavigation:
                //简单的应用跳转
                ARouter.getInstance()
                        .build(PathUtils.PATH_TEST2_ACTIVITY)
                        .navigation(this);
                //ARouterUtils.openPage(PathUtils.PATH_TEST2_ACTIVITY);
                break;
            case R.id.normalNavigationWithParams:
                //携带参数的应用内跳转
                //1.基础类型
                //2.数组类型
                //3.Bundle类型
                //4.跳转动画
                //5.其他类型
                 /*ARouter.getInstance()
                         .build(PathUtils.PATH_TEST2_ACTIVITY)
                         .withString("key1", "value1")
                         .navigation();*/

                 //schema host 任意指定 path正常就可以找到
                /*Uri testUriMix = Uri.parse("xx://xxx.xx.xxx/test/activity2");
                ARouter.getInstance().build(testUriMix)
                        .withString("key1", "value1")
                        .navigation();*/

                Bundle bundle = new Bundle();
                bundle.putString("key1","value1");
                ARouter.getInstance()
                        .build(PathUtils.PATH_TEST2_ACTIVITY)
                        .with(bundle)
                        .navigation();

                /*ARouter.getInstance()
                        .build(PathUtils.PATH_TEST2_ACTIVITY)
                        //.withObject("person",new Person("aaa"))
                        .withSerializable("person",new Person("aaa"))
                        .navigation();*/

                break;
            case R.id.normalNavigation2:
                //类似startActivityForResult
                ARouter.getInstance()
                        .build(PathUtils.PATH_TEST2_ACTIVITY)
                        .navigation(this, 666);
                break;
            case R.id.getFragment:
                //获取fragment实例
                Fragment fragment = (Fragment) ARouter.getInstance().build(PathUtils.PATH_TEST_FRAGMENT).navigation();
                Toast.makeText(this, "找到Fragment:" + fragment.toString(), Toast.LENGTH_SHORT).show();

                //获取fragment实例，可以进行replace等等操作
                break;
            case R.id.oldVersionAnim:
                ARouter.getInstance()
                        .build(PathUtils.PATH_TEST2_ACTIVITY)
                        .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                        .navigation(this);
                break;
            case R.id.newVersionAnim:
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityOptionsCompat compat = ActivityOptionsCompat.
                            makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);

                    ARouter.getInstance()
                            .build(PathUtils.PATH_TEST2_ACTIVITY)
                            .withOptionsCompat(compat)
                            .navigation();
                } else {
                    Toast.makeText(this, "API < 16,不支持新版本动画", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.interceptor:
                ARouter.getInstance()
                        .build(PathUtils.PATH_TEST4_ACTIVITY)
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                super.onFound(postcard);
                                Log.d(Constants.AROUTER_TAG, "找到了");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                super.onLost(postcard);
                                Log.d(Constants.AROUTER_TAG, "找不到了");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.d(Constants.AROUTER_TAG, "跳转完了");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d(Constants.AROUTER_TAG, "被拦截了");
                            }
                        });
                break;
            case R.id.navByUrl:
                ARouter.getInstance()
                        .build("/test/webview")
                        .withString("url", "file:///android_asset/schame-test.html")
                        .navigation();
                break;
            case R.id.autoInject:
                TestSerializable testSerializable = new TestSerializable("Titanic", 555);
                TestParcelable testParcelable = new TestParcelable("jack", 666);
                TestObj testObj = new TestObj("Rose", 777);
                List<TestObj> objList = new ArrayList<>();
                objList.add(testObj);

                Map<String, List<TestObj>> map = new HashMap<>();
                map.put("testMap", objList);

                ARouter.getInstance().build(PathUtils.PATH_TEST1_ACTIVITY)
                        .withString("name", "老王")
                        .withInt("age", 18)
                        .withBoolean("boy", true)
                        .withLong("high", 180)
                        .withString("url", "https://a.b.c")
                        .withSerializable("ser", testSerializable)
                        .withParcelable("pac", testParcelable)
                        .withObject("obj", testObj)
                        .withObject("objList", objList)
                        .withObject("map", map)
                        .navigation();
                break;
            case R.id.navByName:
                //通过路径
                ((HelloService) ARouter.getInstance().build(PathUtils.PATH_SERVICE_HELLO).navigation()).sayHello("mike by name");
                break;
            case R.id.navByType:
                ARouter.getInstance().navigation(HelloService.class).sayHello("mike by type");
                break;
            case R.id.callSingle:
                ARouter.getInstance().navigation(SingleService.class).sayHello("Mike");
                break;
            case R.id.navToMoudle1:
                ARouter.getInstance().build("/module/1").navigation();
                break;
            case R.id.navToMoudle2:
                // 这个页面主动指定了Group名
                ARouter.getInstance().build("/module/2", "m2").navigation();
                break;
            case R.id.failNav:
                ARouter.getInstance().build("/xxx/xxx").navigation(this, new NavCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.d("ARouter", "找到了");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        //单独降级
                        Log.d("ARouter", "单独降级-找不到了");
                        //降级跳转
                        ARouter.getInstance()
                                .build(PathUtils.PATH_TEST2_ACTIVITY)
                                .navigation();
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.d("ARouter", "跳转完了");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.d("ARouter", "被拦截了");
                    }
                });
                break;
            case R.id.failNav2:
                ARouter.getInstance().build("/xxx/xxx").navigation();
                break;
            case R.id.failNav3:
                //ARouter.getInstance().navigation(MainActivity.class);
                ARouter.getInstance().navigation(Test1Activity.class);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 666:
                Log.e(Constants.AROUTER_TAG, String.valueOf(resultCode));
                break;
            default:
                break;
        }
    }
}
