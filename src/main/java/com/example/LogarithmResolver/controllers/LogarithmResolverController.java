package com.example.LogarithmResolver.controllers;

import com.example.LogarithmResolver.model.LogarithmNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogarithmResolverController {
    @GetMapping("/logarithm")
    public LogarithmNumber logarithm(@RequestParam(name="number") String number) {
        Double input = Double.valueOf(number);
        LogarithmNumber logNum = new LogarithmNumber(input);
        logNum.resolveLogarithm();
        return logNum;
    }
}
