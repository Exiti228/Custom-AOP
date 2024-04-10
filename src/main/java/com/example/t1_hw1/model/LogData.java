package com.example.t1_hw1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "test")
@Data
public class LogData {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "duration_ms", nullable = false)
    private Integer durationMs;

    @Column(name = "method_name", nullable = false)
    private String methodName;
}
