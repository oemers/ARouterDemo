package com.ryy.arouterdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ryy.arouterdemo.R;
import com.ryy.arouterdemo.model.TestObj;
import com.ryy.arouterdemo.model.TestParcelable;
import com.ryy.arouterdemo.model.TestSerializable;
import com.ryy.arouterdemo.util.PathUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by renyangyang on 2018/8/14.
 * 有传递的，取值为 传递的值
 * 没有传递的， 取值为默认的值
 */
@Route(path = PathUtils.PATH_TEST1_ACTIVITY)
public class Test1Activity extends AppCompatActivity{

    @Autowired(desc = "姓名")
    String name = "jack";

    @Autowired
    int age = 10;

    @Autowired
    int height = 175;

    @Autowired(name = "boy", required = true)
    boolean girl;

    @Autowired
    char ch = 'A';

    @Autowired
    float fl = 12.00f;

    @Autowired
    double dou = 12.01d;

    @Autowired
    TestSerializable ser;

    @Autowired
    TestParcelable pac;

    @Autowired
    TestObj obj;

    @Autowired
    List<TestObj> objList;

    @Autowired
    Map<String, List<TestObj>> map;

    private long high;

    @Autowired
    String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        ARouter.getInstance().inject(this);


        String params = String.format(
                "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n ser=%s,\n pac=%s,\n obj=%s \n ch=%s \n fl = %s, \n dou = %s, \n objList=%s, \n map=%s",
                name,
                age,
                height,
                girl,
                high,
                url,
                ser,
                pac,
                obj,
                ch,
                fl,
                dou,
                objList,
                map
        );
        ((TextView) findViewById(R.id.tv_param)).setText(params);
    }
}
