package com.example.LogarithmResolver.services.interfaces;

import com.example.LogarithmResolver.model.InputParam;
import org.springframework.stereotype.Service;

@Service
public interface MonitoringService {
    void registerLogarithmBase10orMore(InputParam input);
}
