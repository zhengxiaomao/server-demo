package com.example.serverdemo.service;

import com.example.serverdemo.dao.CpuDao;
import com.example.serverdemo.dao.MemDao;
import com.example.serverdemo.dao.NetDao;
import com.example.serverdemo.entity.Cpu;
import com.example.serverdemo.entity.Mem;
import com.example.serverdemo.entity.Net;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: DevanYan
 * @create: 2019-05-28 11:46
 */

//消息的消费者
@Component
public class Consumer {

    @Autowired
    Cpu cpu;
    @Autowired
    Mem mem;
    @Autowired
    CpuDao cpuDao;
    @Autowired
    MemDao memDao;
    @Autowired
    Net net;
    @Autowired
    NetDao netDao;

    @RabbitListener(queues = "item_queue_cpu")
    @RabbitHandler
    public void cpuConsumer(Map map) {

        cpu.setNice(map.get("nice"));
        cpu.setIrq(map.get("irq"));
        cpu.setSys(map.get("sys"));
        cpu.setUser(map.get("user"));
        cpu.setSteal(map.get("steal"));
        cpu.setSoft_irq(map.get("sofrtirq"));
        cpu.setContext_switches(map.get("contextSwitches"));
        cpu.setIo_wait(map.get("iowait"));
        cpu.setIp(map.get("ip"));
        cpu.setTime(map.get("time"));
        cpu.setId(map.get("id"));
        cpu.setInterrupts(map.get("interrupts"));
        cpu.setIdle(map.get("idle"));
        cpuDao.insert(cpu);

    }

    @RabbitListener(queues = "item_queue_mem")
    @RabbitHandler
    public void memConsumer(Map map){
        mem.setFreeMem(map.get("free"));
        mem.setUsedMem(map.get("used"));
        mem.setTotalMem(map.get("total"));
        mem.setIp(map.get("ip"));
        mem.setTime(map.get("time"));
        memDao.insert(mem);

    }

    @RabbitListener(queues = "item_queue_net")
    @RabbitHandler
    public void netConsumer(Map map){
        net.setIp(map.get("ip"));
        net.setMacAddr(map.get("macAddr"));
        net.setNetCardName(map.get("netCardName"));
        net.setReceiveBytes(map.get("receiveBytes"));
        net.setReceivePackets(map.get("receivePackets"));
        net.setSentBytes(map.get("sentPackets"));
        net.setSentPackets(map.get("sentPackets"));
        net.setReceivePacketsErrors(map.get("receivePacketsErrors"));
        net.setSentPacketsErrors(map.get("sentPacketsErrors"));
        net.setTime(map.get("time"));
        netDao.insert(net);

    }




}