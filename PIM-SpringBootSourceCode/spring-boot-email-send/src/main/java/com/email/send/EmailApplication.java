package com.email.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * @Description: 发送邮箱服务
 * @Author: liyuze
 * @Date: 2020/5/11 14:38
 */
@EnableAsync //使用多线程，@Async加在线程任务的方法上（需要异步执行的任务），定义一个线程任务，通过spring提供的ThreadPoolTaskExecutor就可以使用线程池
@SpringBootApplication
public class EmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class,args) ;
    }
}
