package com.example.serverdemo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Disk {

    private Float total_size;
    private Float used_size;


}
