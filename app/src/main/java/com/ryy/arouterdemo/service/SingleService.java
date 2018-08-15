package com.ryy.arouterdemo.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/15.
 */
@Route(path = PathUtils.PATH_SERVICE_SINGLE)
public class SingleService implements IProvider {

    Context mContext;

    public void sayHello(String name) {
        Toast.makeText(mContext, "Hello " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
