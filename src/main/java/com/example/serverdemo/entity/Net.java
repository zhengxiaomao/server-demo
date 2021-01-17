package com.example.serverdemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Data
public class Net<T> {



   private T id;
   private T sentPackets;
   private T receivePackets;
   private T receiveBytes;
   private T sentBytes;
   private T receivePacketsErrors;
   private T sentPacketsErrors;
   private T macAddr;
   private T netCardName;
   private T ip;
   private T time;

}
