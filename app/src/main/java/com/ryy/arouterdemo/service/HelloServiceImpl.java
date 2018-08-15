package com.ryy.arouterdemo.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ryy.arouterdemo.constant.Constants;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/15.
 */
@Route(path = PathUtils.PATH_SERVICE_HELLO)
public class HelloServiceImpl implements HelloService {

    Context mContext;

    @Override
    public void init(Context context) {
        mContext = context;
        Log.e(Constants.AROUTER_TAG, HelloService.class.getName() + " has init.");
    }

    @Override
    public void sayHello(String name) {
        Toast.makeText(mContext, "Hello " + name, Toast.LENGTH_SHORT).show();
    }
}
