package com.example.t1_hw1.service;

import com.example.t1_hw1.model.LogData;
import com.example.t1_hw1.repository.LogDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogDataService {
    private final LogDataRepository logDataRepository;

    public boolean save(LogData logData) {
        try {
            logDataRepository.save(logData);
            return true;
        }
        catch (Exception e) {
            log.error("Exception while save data log:", e);
        }
        return false;
    }

    public Double getLogDataSumByMethodNameEquals(String methodName) {
        return logDataRepository.getLogDataSumByMethodNameEquals(methodName);
    }
    public Double getLogDataAvgByMethodName(String methodName) {
        return logDataRepository.getLogDataAvgByMethodName(methodName);
    }
}
