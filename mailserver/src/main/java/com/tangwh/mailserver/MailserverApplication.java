package com.tangwh.mailserver;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class MailserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailserverApplication.class, args);
    }

    /**
     * 消息队列
     * @return
     */
    @Bean
    Queue queue(){

        return new Queue("javaboy.mail.welcome");
    }
}
