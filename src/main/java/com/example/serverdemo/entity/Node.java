package com.example.serverdemo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Node {

    public String ip;
    public int port;
    
}
