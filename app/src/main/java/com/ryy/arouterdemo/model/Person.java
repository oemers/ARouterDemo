package com.ryy.arouterdemo.model;

import java.io.Serializable;

/**
 * Created by renyangyang on 2018/8/14.
 */
public class Person implements Serializable{
     public String name;

     public Person(String name){
         this.name = name;
     }

    @Override
    public String toString() {
        return name;
    }
}
