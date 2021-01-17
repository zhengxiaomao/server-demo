package com.example.serverdemo.dao;

import com.example.serverdemo.entity.Mem;
import com.example.serverdemo.entity.Net;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface NetDao {


    public void insert(Net net);

    @Select("select * from mem where  time>=#{startTime} and time<#{endTime}")
    public List<Net> select(String ip, String startTime, String endTime);

}
