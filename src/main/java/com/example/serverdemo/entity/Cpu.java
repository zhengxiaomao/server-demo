package com.example.serverdemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Data
public class Cpu<T> {

    T id;
    T time;
    T ip;
    T context_switches;
    T interrupts;
    T idle;
    T steal;
    T irq;
    T soft_irq;
    T io_wait;
    T sys;
    T user;
    T nice;


}
