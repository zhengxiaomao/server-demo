package com.example.serverdemo.service;


import com.alibaba.fastjson.JSON;
import com.example.serverdemo.dao.CpuDao;
import com.example.serverdemo.dao.MemDao;
import com.example.serverdemo.dao.NetDao;
import com.example.serverdemo.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Component
public class grab {

    @Autowired
    Jvm jvm;
    @Autowired
    Mem mem;
    @Resource
    Cpu cpu;
    @Autowired
    Net net;
    @Autowired
    NetDao netDao;
    @Autowired
    MemDao memDao;
    @Autowired
    CpuDao cpuDao;
    @Autowired
    Disk disk;

    public static String HttpRestClient(String url, HttpMethod method) throws IOException {


        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10*1000);
        requestFactory.setReadTimeout(10*1000);
        RestTemplate client = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8);
        HttpEntity requestEntity = new HttpEntity(headers);
        //  执行HTTP请求
        ResponseEntity response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody().toString();

    }

    private static HashMap toHashMap(Object object)
    {
        HashMap data = new HashMap();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext())
        {
            Object key = String.valueOf(it.next());
            Object value =  jsonObject.get(key);
            data.put(key, value);

        }
        return data;
    }




    public  synchronized  void  request(String ip,int port) {

        try {

            Date date = new Date();
            String strDateFormat = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            String time=sdf.format(date);


            /*
               获取jvm信息
             */
            String jvmRet=HttpRestClient("http://"+ip+":"+port+"/sys/jvm", HttpMethod.GET);
            HashMap<Object, Object> jvmMp = toHashMap(jvmRet.toString());
            jvm.setJvmName(jvmMp.get("name"));
            jvm.setStartTime(jvmMp.get("startTime"));
            jvm.setJvmVersion(jvmMp.get("version"));
            jvm.setFreeMemory(jvmMp.get("free"));
            jvm.setHomeDictory(jvmMp.get("home"));
            jvm.setUsedMemory(jvmMp.get("usage"));
            jvm.setRunTime(jvmMp.get("runTime"));
            jvm.setTotalMemory(jvmMp.get("total"));
            jvm.setMaxMemory(jvmMp.get("max"));

            /*
              获取内存数据

             */
            String memRet=HttpRestClient("http://"+ip+":"+port+"/sys/mem", HttpMethod.GET);
            HashMap<Object, Object> memMp = toHashMap(memRet.toString());
//            System.out.println(memMp);
            mem.setTime(time);
            mem.setIp(ip);
            mem.setFreeMem(memMp.get("free"));
            mem.setTotalMem(memMp.get("Total"));
            mem.setUsedMem(memMp.get("Used"));
            memDao.insert(mem);


            /*
              获取cpu数据
             */

            String cpuRet=HttpRestClient("http://"+ip+":"+port+"/sys/cpu", HttpMethod.GET);
            HashMap<Object, Object> cpuMp = toHashMap(cpuRet.toString());
            cpu.setTime(time);
            cpu.setIp(ip);
            cpu.setContext_switches(cpuMp.get("contextSwitches"));
            cpu.setInterrupts(cpuMp.get("interrupts"));
            cpu.setIdle(cpuMp.get("idle"));
            cpu.setSteal(cpuMp.get("steal"));
            cpu.setIrq(cpuMp.get("irq"));
            cpu.setSoft_irq(cpuMp.get("sofrtirq"));
            cpu.setIo_wait(cpuMp.get("iowait"));
            cpu.setSys(cpuMp.get("sys"));
            cpu.setUser(cpuMp.get("user"));
            cpu.setNice(cpuMp.get("nice"));
            cpuDao.insert(cpu);



            /*
               获取网络数据
             */
            String netRet=HttpRestClient("http://"+ip+":"+port+"/sys/net", HttpMethod.GET);
            Map netMp = (Map) JSON.parse(netRet);
            JSONObject jsonObject = JSONObject.fromObject(netMp);
            ObjectMapper mapper = new ObjectMapper();
            for(Object key:netMp.keySet()){
                Net net = mapper.readValue(netMp.get(key).toString(),Net.class);
                net.setTime(time);
                String ip1=net.getIp().toString().replace("[","");
                String ip2=ip1.replace("]","");
                net.setIp(ip2);
                netDao.insert(net);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


