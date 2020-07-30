package com.example.LogarithmResolver.services.impl;

import com.example.LogarithmResolver.model.InputParam;
import com.example.LogarithmResolver.services.interfaces.LogarithmResolverService;
import org.springframework.stereotype.Service;

@Service
public class LogarithmResolverServiceImpl implements LogarithmResolverService {
    @Override
    public Double resolveLogarithm(InputParam input) {
        Double base = input.getBase();
        Double number = input.getNumber();
        Double result = Math.log(number) / Math.log(base);
        return result;
    }
}
