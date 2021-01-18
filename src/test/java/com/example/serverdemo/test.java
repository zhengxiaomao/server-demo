package com.example.serverdemo;


import com.alibaba.fastjson.JSON;
import com.example.serverdemo.service.Consumer;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import sun.net.www.http.HttpClient;

import java.util.List;
import java.util.Map;

public class test {


    @Test
    public void test1() throws Exception{
        CloseableHttpClient httpClient= HttpClients.createDefault();
        URIBuilder uriBuilder= new URIBuilder("http://127.0.0.1:8888/v1/haha");
        HttpGet get = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = httpClient.execute(get);
        String result=EntityUtils.toString(response.getEntity());
        System.out.println(result);

    }






}
