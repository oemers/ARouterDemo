package com.ryy.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by renyangyang on 2018/8/15.
 */
@Route(path = "/module/1")
public class TestModuleActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module);
    }
}
