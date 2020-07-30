package com.example.LogarithmResolver.controllers;

import com.example.LogarithmResolver.model.InputParam;
import com.example.LogarithmResolver.model.ResponseMessage;
import com.example.LogarithmResolver.services.interfaces.LogarithmResolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogarithmResolverController {

    @Autowired
    private LogarithmResolverService logarithmService;

    @GetMapping("/logarithm")
    public ResponseMessage logarithm(@RequestParam(name="base") String base, @RequestParam(name="number") String number) {
        double inputNumber = Double.parseDouble(number);
        double inputBase = Double.parseDouble(base);
        InputParam inputParam = new InputParam(inputBase, inputNumber);
        Double result = logarithmService.resolveLogarithm(inputParam);

        return new ResponseMessage(1,"Success", inputParam, result);
    }
}
