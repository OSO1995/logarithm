package com.example.LogarithmResolver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseMessage {
    private int responseCode;
    private String responseMessage;
    private InputParam inputParam;
    private double result;
}
