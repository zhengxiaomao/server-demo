package com.example.serverdemo.entity;

import java.lang.reflect.Constructor;

public class Generate {

    public String className;
    public String ip;
    public String time;

    public Generate(String className,String ip,String time){
        this.className=className;
        this.ip=ip;
        this.time=time;
    }

    public Object generateObj() throws Exception{

        Class c=Class.forName(className);

        Constructor cons=c.getConstructor(String.class,String.class,String.class);
        System.out.println(cons);
        return cons.newInstance();
    }


}
