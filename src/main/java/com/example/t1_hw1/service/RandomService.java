package com.example.t1_hw1.service;

import com.example.t1_hw1.annotation.TrackAsyncTime;
import com.example.t1_hw1.annotation.TrackTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class RandomService {
    private final LogDataService logDataService;
    final static Random random = new Random();

    @TrackTime
    public void doSomething() throws InterruptedException {
        Thread.sleep(1000);
    }

    @TrackAsyncTime
    public void doSomething2() throws InterruptedException {
        Thread.sleep(random.nextInt(3000));
    }

    @TrackAsyncTime
    public void doSomething3() throws InterruptedException {
        Thread.sleep(random.nextInt(3000));
    }
}
