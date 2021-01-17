package com.example.serverdemo.dao;

import com.example.serverdemo.entity.Cpu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CpuDao {


    public void insert(Cpu cpu);

    public  List<Cpu> select(String ip,String startTime,String endTime);


}
