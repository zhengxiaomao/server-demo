package com.example.serverdemo.controller;

import com.example.serverdemo.service.query;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/query/")
public class QueryCpu {

    @Resource
    query query;

    @RequestMapping(value = "/{ip}/metrics/cpu/{startTime}/{endTime}",method = RequestMethod.GET)
    @ResponseBody
    public Map queryCpu(@PathVariable String ip, @PathVariable String startTime, @PathVariable String endTime){

        return query.queryCpu(ip,startTime,endTime);

    }
}
