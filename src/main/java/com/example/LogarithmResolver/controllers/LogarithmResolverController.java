package com.example.LogarithmResolver.controllers;

import com.example.LogarithmResolver.model.InputParam;
import com.example.LogarithmResolver.model.ResponseMessage;
import com.example.LogarithmResolver.services.interfaces.LogarithmResolverService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LogarithmResolverController {

    @Autowired
    private LogarithmResolverService logarithmService;

    @GetMapping("/logarithm")
    public ResponseMessage logarithm(@RequestParam(name="base") String base, @RequestParam(name="number") String number) {
        log.info("base = " + base + " number = " + number);
        double inputNumber = Double.parseDouble(number);
        double inputBase = Double.parseDouble(base);
        InputParam inputParam = new InputParam(inputBase, inputNumber);
        Double result = logarithmService.resolveLogarithm(inputParam);

        log.info("result = " + result);
        return new ResponseMessage(1,"Success", inputParam, result);
    }
}
