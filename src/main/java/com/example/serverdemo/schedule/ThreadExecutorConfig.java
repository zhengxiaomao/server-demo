package com.example.serverdemo.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@Component
public class ThreadExecutorConfig {


    @Bean(name="taskExecutor2")
    public Executor executor() {
        System.out.println("启动线程池");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);//线程池维护线程的最少数量
        executor.setMaxPoolSize(5000);//线程池维护线程的最大数量
        executor.setQueueCapacity(1500);//缓存队列
        executor.setThreadNamePrefix("ssmsExecutor-");
        /**
         * 对拒绝task的处理策略
         rejection-policy：当pool已经达到max size的时候，如何处理新任务
         CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setKeepAliveSeconds(60);//允许的空闲时间
        executor.initialize();
        return executor;
    }

}