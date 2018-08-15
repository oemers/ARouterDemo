package com.ryy.arouterdemo.model;

import java.io.Serializable;

/**
 * Created by renyangyang on 2018/8/15.
 */
public class TestSerializable implements Serializable {
    public String name;
    public int id;

    public TestSerializable() {
    }

    public TestSerializable(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestSerializable{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
