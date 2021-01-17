package com.example.serverdemo.schedule;

import com.example.serverdemo.service.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Iterator;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class Run {

//    @Autowired
//    Request request;
//    @Scheduled(cron = "0/5 * * * * ?")
//    @Async("taskExecutor2")
//    public  void run() throws Exception{
//
//        Map map = config.hm;
//
//        Thread.sleep(8000);
//
//        for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
//            String ip = (String)it.next();
//            Integer port = (Integer)map.get(ip);
//            request.run(ip,port);
//
//        }
//
//
//
//
//
//
//
//    }
}
