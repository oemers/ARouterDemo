package com.ryy.arouterdemo.interceptor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ryy.arouterdemo.constant.Constants;
import com.ryy.arouterdemo.util.MainLooper;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/14.
 * 按优先级执行 越小越先执行
 */
@Interceptor(priority = 8, name = "测试")
public class TestInterceptor implements IInterceptor{

    private Context mContext;//application的

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//callback.onContinue(postcard);  // 处理完成，交还控制权
        // callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程

        // 以上两种至少需要调用其中一种，否则不会继续路由
        if (PathUtils.PATH_TEST4_ACTIVITY.equals(postcard.getPath())) {
            MainLooper.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext,"不拦截",Toast.LENGTH_SHORT).show();
                }
            });

            //callback.onContinue(postcard);
            ARouter.getInstance().build(PathUtils.PATH_TEST1_ACTIVITY).navigation();
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        mContext = context;
        Log.e(Constants.AROUTER_TAG, TestInterceptor.class.getName() + " has init.");
    }
}
