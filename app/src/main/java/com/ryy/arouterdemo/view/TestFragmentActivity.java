package com.ryy.arouterdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ryy.arouterdemo.util.PathUtils;


/**
 * Created by renyangyang on 2018/8/14.
 */
@Route(path = PathUtils.PATH_TEST_FRAGMENT_ACTIVITY)
public class TestFragmentActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout rootView = new FrameLayout(this);
        final int h = ViewGroup.LayoutParams.MATCH_PARENT;
        rootView.setLayoutParams(new ViewGroup.LayoutParams(h, h));
        rootView.setId(android.R.id.primary);
        setContentView(rootView);

        TestFragment fragment = new TestFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启一个事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.primary,fragment);
        fragmentTransaction.commitAllowingStateLoss();

    }
}
