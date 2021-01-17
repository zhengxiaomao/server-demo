package com.example.serverdemo.controller;


import com.example.serverdemo.service.config;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add/")
public class ConfigNode {



    @RequestMapping(value = "/{ip}/{port}",method = RequestMethod.GET)
    @ResponseBody
    public String addNode(@PathVariable String ip,@PathVariable int port){
        config.hm.put(ip,port);
        return "添加成功";
    }

}
