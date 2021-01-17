package com.example.serverdemo.dao;

import com.example.serverdemo.entity.Mem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface MemDao {



//    @Insert({"insert into mem(time,ip,freeMem,totalMem,usedMem) values(#{time},#{ip},#{freeMem},#{totalMem},#{usedMem})"})
    public void insert(Mem mem);


//   @Select("select * from mem where ip=#{ip} and time>=#{startTime}")
    public List<Mem> select(String ip,String startTime,String endTime);


}