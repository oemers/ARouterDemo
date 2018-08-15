package com.ryy.arouterdemo.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ryy.arouterdemo.BuildConfig;

/**
 * Created by renyangyang on 2018/8/14.
 */
public class ARouterUtils {
    public static void init(Application application) {
        if (BuildConfig.IS_DEBUG) {   // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
    }

    public static void destroy(){
        ARouter.getInstance().destroy();
    }

    /**
     *
     * @param obj
     */
    public static void inject(Object obj) {
        ARouter.getInstance().inject(obj);
    }

    /**
     * 打开指定路径的页面
     */
    public static Object openPage(String nextPagePath) {
        return openPage(nextPagePath, null, 0, null);
    }

    /**
     * 打开指定路径的页面
     */
    public static Object openPage(String nextPagePath, NavigationCallback callback) {
        return openPage(nextPagePath, null, 0, callback);
    }

    /**
     * 同上，但是不需要传bundle
     */
    public static Object openPage(String nextPagePath, @Nullable Bundle bundle) {
        return openPage(nextPagePath, bundle, 0, null);
    }

    /**
     * 打开指定路径的页面
     */
    public static Object openPage(String nextPagePath, Bundle bundle, int flags) {
        return openPage(nextPagePath, bundle, flags, null);
    }

    /**
     * 同上，但是不需要传bundle
     */
    public static Object openPage(String nextPagePath, @Nullable Bundle bundle, NavigationCallback callback) {
        return openPage(nextPagePath, bundle, 0, callback);
    }

    /**
     * 同上，但是不需要传bundle
     */
    public static Object openPage(String nextPagePath, @Nullable Bundle bundle, int flags, NavigationCallback callback) {
        Postcard postcard = ARouter.getInstance().build(nextPagePath);
        if (bundle == null) {
            bundle = new Bundle();
        }
        postcard.with(bundle);
        if (flags > 0) {
            postcard.withFlags(flags);
        }
        return postcard.navigation(null, callback);
    }

    /**
     * 构建标准的路由请求，startActivityForResult
     * navigation的第一个参数必须是Activity，第二个参数则是RequestCode
     */
    public static void openActivityForResult(Activity activity, String nextPagePath,
                                             @Nullable Bundle bundle, int requestCode) {
        Postcard postcard = ARouter.getInstance().build(nextPagePath);
        if (bundle == null) {
            bundle = new Bundle();
        }
        postcard.with(bundle);
        postcard.navigation(activity, requestCode);
    }
}
