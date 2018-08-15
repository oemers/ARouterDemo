package com.ryy.arouterdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ryy.arouterdemo.R;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/14.
 * 1.通过注解 获取传递参数
 * 2.通过getintent 获取传递参数
 * 3.通过bundle 获取传递参数
 */
@Route(path = PathUtils.PATH_TEST2_ACTIVITY)
public class Test2Activity extends AppCompatActivity{

    //@Autowired(name = "key1")
    //String value;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        //1
        //ARouter.getInstance().inject(this);

        //2
        String value = getIntent().getStringExtra("key1");
        //Person person = (Person) getIntent().getSerializableExtra("peron");

        //3
        /*Bundle bundle = getIntent().getExtras();
        String value = "";
        if (bundle != null){
            value = bundle.getString("key1");
        }*/

        if (!TextUtils.isEmpty(value)) {
            Toast.makeText(this, "exist param :" + value, Toast.LENGTH_SHORT).show();
        }
        //if (person != null) {
            //Toast.makeText(this, "exist param :" + person.name, Toast.LENGTH_SHORT).show();
        //}

    }
}
