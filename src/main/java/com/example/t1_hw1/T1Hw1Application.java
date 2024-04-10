package com.example.t1_hw1;

import com.example.t1_hw1.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class T1Hw1Application {

    private final RandomService randomService;
    public static void main(String[] args) {
        SpringApplication.run(T1Hw1Application.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onReady() throws InterruptedException {
        randomService.doSomething2();
        randomService.doSomething2();
        randomService.doSomething2();
        Thread.sleep(10000);
    }

}
