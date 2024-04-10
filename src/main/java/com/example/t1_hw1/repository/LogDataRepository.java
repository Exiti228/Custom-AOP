package com.example.t1_hw1.repository;

import com.example.t1_hw1.model.LogData;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDataRepository extends JpaRepository<LogData, Long> {
    @Query(value = "SELECT SUM(t.duration_ms) FROM test t WHERE t.method_name = ?1" , nativeQuery = true)
    Double getLogDataSumByMethodNameEquals(String methodName);
    @Query(value = "SELECT AVG(t.duration_ms) FROM test t WHERE t.method_name = ?1" , nativeQuery = true)
    Double getLogDataAvgByMethodName(String methodName);
}
