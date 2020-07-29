package com.example.LogarithmResolver.controllers;

import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Component
@Endpoint(id="readiness")
public class Readiness {
    public static final long START_SERVICE_DELAY = 120000;

    @ReadOperation
    public String readiness() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long time = runtimeMXBean.getUptime();
        if(time < START_SERVICE_DELAY) {
            return "Service starting...";
        }
        return "Service start";
    }
}
