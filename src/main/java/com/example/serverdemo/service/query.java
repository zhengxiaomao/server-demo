package com.example.serverdemo.service;

import com.example.serverdemo.dao.CpuDao;
import com.example.serverdemo.dao.MemDao;
import com.example.serverdemo.dao.NetDao;
import com.example.serverdemo.entity.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class query {

    @Autowired
    MemDao memDao;
    @Autowired
    CpuDao cpuDao;
    @Autowired
    Mem mem;
    @Autowired
    query query;
    @Autowired
    NetDao netDao;

    public HashMap queryMem(String ip,String startTime,String endTime){

        HashMap hm = new HashMap();
        List result= memDao.select(ip,startTime,endTime);
        System.out.println(startTime);
        for(int i=0;i<result.size();i++){
            hm.put(i,result.get(i));
        }
        return hm;
    }

    public Map queryNet(String ip,String startTime,String endTime){

        Map hm1 = new HashMap();
        List result= netDao.select(ip,startTime,endTime);
        System.out.println(startTime);
        for(int i=0;i<result.size();i++){
            hm1.put(i,result.get(i));
        }
        return hm1;
    }




}
