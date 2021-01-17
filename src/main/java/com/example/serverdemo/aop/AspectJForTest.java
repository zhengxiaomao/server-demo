package com.example.serverdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class AspectJForTest {

    @Pointcut("execution(*  com.example.serverdemo.schedule.Run.run(..))")
    private void execute(){}

    @Before("execute()")
    public void b(){
        System.out.println("调用run方法前");
    }

    @After("execute()")
    public void a(){
        System.out.println("调用run方法后");
    }


    @Around("execute()")
    public void around(ProceedingJoinPoint pjp){
        try{
            Long start = System.currentTimeMillis();
            pjp.proceed();
            Long end = System.currentTimeMillis();
            System.out.println("耗时:"+(end-start));
        }catch (Exception e){
            System.out.println("Around....c");
            e.printStackTrace();
        } catch (Throwable throwable) {
            System.out.println("Around....d");
            throwable.printStackTrace();
        }
    }

}
