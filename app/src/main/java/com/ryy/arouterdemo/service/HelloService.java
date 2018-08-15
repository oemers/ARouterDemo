package com.ryy.arouterdemo.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by renyangyang on 2018/8/15.
 */
public interface HelloService extends IProvider{
    void sayHello(String name);
}
