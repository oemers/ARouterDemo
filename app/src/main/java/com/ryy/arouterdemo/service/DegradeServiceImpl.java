package com.ryy.arouterdemo.service;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.ryy.arouterdemo.constant.Constants;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/15.
 * 调用到的时候 才会初始化
 */
@Route(path = PathUtils.PATH_TEST_LOST)
public class DegradeServiceImpl implements DegradeService{
    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.d(Constants.AROUTER_TAG, "全局降级-找不到了");
    }

    @Override
    public void init(Context context) {
        Log.e(Constants.AROUTER_TAG, DegradeServiceImpl.class.getName() + " has init.");
    }
}
