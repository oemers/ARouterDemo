package com.ryy.arouterdemo.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by renyangyang on 2018/8/15.
 * schema跳转中间页
 * 在这里通过arouter跳转
 */
public class SchameFilterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation();
        finish();
    }
}
