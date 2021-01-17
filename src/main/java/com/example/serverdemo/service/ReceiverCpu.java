package com.example.serverdemo.service;


import com.example.serverdemo.dao.CpuDao;
import com.example.serverdemo.entity.Cpu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.example.serverdemo.config.*;

import java.util.Map;

@Component
@Slf4j
public class ReceiverCpu {

    @Autowired
    Cpu cpu;

    @Autowired
    CpuDao cpuDao;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMQConfig.ITEM_QUEUE_CPU, durable = "true"),
            exchange = @Exchange(value = RabbitMQConfig.ITEM_TOPIC_EXCHANGE_CPU, type = ExchangeTypes.TOPIC),
            key = RabbitMQConfig.ITEM__TOPIC_CPU_ROUTINGKEY)
    )
    public void onOrgDeleted(@Payload Map msg) {

        cpu.setIdle(msg.get("idle"));
        cpu.setTime(msg.get("time"));
        cpu.setIp(msg.get("ip"));
        cpu.setIo_wait(msg.get("iowait"));
        cpu.setContext_switches(msg.get("contextSwitches"));
        cpu.setInterrupts(msg.get("interrupts"));
        cpu.setSoft_irq(msg.get("sofrtirq"));
        cpu.setSteal(msg.get("steal"));
        cpu.setUser(msg.get("user"));
        cpu.setSys(msg.get("sys"));
        cpu.setIrq(msg.get("irq"));
        cpu.setNice(msg.get("nice"));
        System.out.println(msg.get("user"));
        cpuDao.insert(cpu);


    }
}