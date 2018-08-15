package com.ryy.arouterdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ryy.arouterdemo.R;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/14.
 */
@Route(path = PathUtils.PATH_TEST4_ACTIVITY)
public class Test4Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
    }
}
