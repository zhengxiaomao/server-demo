package com.example.serverdemo.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //交换机名称
    public static final String ITEM_TOPIC_EXCHANGE_CPU = "item_topic_cpu";
    public static final String ITEM_TOPIC_EXCHANGE_MEM = "item_topic_mem";
    //队列名称
    public static final String ITEM_QUEUE_CPU = "item_queue_cpu";
    public static final String ITEM_QUEUE_MEM = "item_queue_mem";
    public static final String ITEM_QUEUE_DISK = "item_queue_disk";
    public static final String ITEM_QUEUE_NET = "item_queue_net";

    public static final String ITEM__TOPIC_CPU_ROUTINGKEY="cpu_metrics";
    public static final String ITEM__TOPIC_MEM_ROUTINGKEY="mem_metrics";

    //声明交换机
    @Bean("itemTopicExchangeCpu")
    public Exchange topicExchangeCpu(){
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE_CPU).durable(true).build();
    }
    @Bean("itemTopicExchangeMem")
    public Exchange topicExchangeMem(){
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE_MEM).durable(true).build();
    }

    //声明队列
    @Bean("itemQueueCPU")
    public Queue itemQueueCpu(){
        return QueueBuilder.durable(ITEM_QUEUE_CPU).build();
    }

    @Bean("itemQueueMem")
    public Queue itemQueueMem(){
        return QueueBuilder.durable(ITEM_QUEUE_MEM).build();
    }

    @Bean("itemQueueNet")
    public Queue itemQueueNet(){
        return QueueBuilder.durable(ITEM_QUEUE_NET).build();
    }
    @Bean("itemQueueDisk")
    public Queue itemQueueDisk(){
        return QueueBuilder.durable(ITEM_QUEUE_DISK).build();
    }


    //绑定队列和交换机
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueueCPU") Queue queue,
                                     @Qualifier("itemTopicExchangeCpu") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ITEM__TOPIC_CPU_ROUTINGKEY).noargs();
    }
    @Bean
    public Binding itemQueueExchangeMem(@Qualifier("itemQueueMem") Queue queue,
                                     @Qualifier("itemTopicExchangeMem") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ITEM__TOPIC_MEM_ROUTINGKEY).noargs();
    }

}