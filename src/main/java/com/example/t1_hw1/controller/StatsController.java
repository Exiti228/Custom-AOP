package com.example.t1_hw1.controller;

import com.example.t1_hw1.response.AvgLogDataResponse;
import com.example.t1_hw1.response.SumLogDataResponse;
import com.example.t1_hw1.service.LogDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class StatsController {
    private final LogDataService logDataService;

    @GetMapping("avg/{methodName}")
    public ResponseEntity<AvgLogDataResponse> avgTimeMethod(@PathVariable String methodName) {
        AvgLogDataResponse avgLogDataResponse = new AvgLogDataResponse();
        try {
            avgLogDataResponse.setAvg(logDataService.getLogDataSumByMethodNameEquals(methodName));
            return ResponseEntity.status(HttpStatus.OK).body(avgLogDataResponse);
        }
        catch (Exception e) {
            log.error("Error avg StatsController: " + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(avgLogDataResponse);
    }

    @GetMapping("sum/{methodName}")
    public ResponseEntity<SumLogDataResponse> sumTimeMethod(@PathVariable String methodName) {
        SumLogDataResponse sumLogDataResponse = new SumLogDataResponse();
        try {
            sumLogDataResponse.setSum(logDataService.getLogDataAvgByMethodName(methodName));
            return ResponseEntity.status(HttpStatus.OK).body(sumLogDataResponse);
        }
        catch (Exception e) {
            log.error("Error sum StatsController: " + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(sumLogDataResponse);
    }
}
