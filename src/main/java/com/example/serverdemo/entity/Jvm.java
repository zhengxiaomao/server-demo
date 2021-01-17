package com.example.serverdemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Jvm<T> {


    T jvmName;
    T startTime;
    T jvmVersion;
    T freeMemory;
    T homeDictory;
    T memoryUsage;
    T runTime;
    T totalMemory;
    T maxMemory;
    T usedMemory;

}
