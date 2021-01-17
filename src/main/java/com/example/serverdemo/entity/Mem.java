package com.example.serverdemo.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public class Mem<T> {

    T time;
    T ip;
    T usedMem;
    T totalMem;
    T freeMem;

    public HashMap result(){
        HashMap hp = new HashMap();
        hp.put("时间:",time);
        hp.put("ip:",ip);
        hp.put("已使用内存",usedMem);
        hp.put("总内存:",totalMem);
        hp.put("剩余内存:",freeMem);
        return hp;
    }
    public void show(){
        System.out.printf(ip+"  "+time);
    }



}
