package com.ryy.arouterdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ryy.arouterdemo.R;
import com.ryy.arouterdemo.util.PathUtils;

/**
 * Created by renyangyang on 2018/8/14.
 */
@Route(path = PathUtils.PATH_TEST_FRAGMENT)
public class TestFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        return view;
    }
}
