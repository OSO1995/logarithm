package com.example.LogarithmResolver.services.impl;

import com.example.LogarithmResolver.model.InputParam;
import com.example.LogarithmResolver.services.interfaces.LogarithmResolverService;
import com.example.LogarithmResolver.services.interfaces.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogarithmResolverServiceImpl implements LogarithmResolverService {

    @Autowired
    private MonitoringService monitoringService;

    @Override
    public Double resolveLogarithm(InputParam input) {
        monitoringService.registerLogarithmBase10orMore(input);

        Double base = input.getBase();
        Double number = input.getNumber();
        Double result = Math.log(number) / Math.log(base);

        return result;
    }
}
