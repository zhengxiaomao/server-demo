package com.example.serverdemo.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test  extends Disk {

    public static void main(String[] args) throws Exception {


        Class c = Class.forName("com.example.serverdemo.entity.Mem");
        Constructor cons = c.getConstructor(String.class, String.class);
        Mem mem = (Mem) cons.newInstance("1.0.0.0", "2020-12-23 21:48");


    }

}
