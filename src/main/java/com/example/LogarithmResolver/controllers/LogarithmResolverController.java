package com.example.LogarithmResolver.controllers;

import com.example.LogarithmResolver.model.InputParam;
import com.example.LogarithmResolver.model.ResponseMessage;
import com.example.LogarithmResolver.services.interfaces.LogarithmResolverService;
import org.fluentd.logger.FluentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogarithmResolverController {

    private static FluentLogger LOG = FluentLogger.getLogger(LogarithmResolverController.class.getName(), "localhost", 24224);

    @Autowired
    private LogarithmResolverService logarithmService;

    @GetMapping("/logarithm")
    public ResponseMessage logarithm(@RequestParam(name="base") String base, @RequestParam(name="number") String number) {
        LOG.log("thisIsTag1", "key = " + "base", "value = " + base);
        LOG.log("thisIsTag2", "key = " + "number", "value = " + number);
        double inputNumber = Double.parseDouble(number);
        double inputBase = Double.parseDouble(base);
        InputParam inputParam = new InputParam(inputBase, inputNumber);
        Double result = logarithmService.resolveLogarithm(inputParam);

        LOG.log("thisIsTag3", "key = " + "result", "value = " + result);

        return new ResponseMessage(1,"Success", inputParam, result);
    }
}
