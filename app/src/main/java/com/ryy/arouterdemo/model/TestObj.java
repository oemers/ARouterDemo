package com.ryy.arouterdemo.model;

/**
 * Created by renyangyang on 2018/8/15.
 */
public class TestObj {
    public String name;
    public int id;

    public TestObj() {
    }

    public TestObj(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
