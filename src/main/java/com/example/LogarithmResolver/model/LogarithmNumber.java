package com.example.LogarithmResolver.model;

public class LogarithmNumber {
    private double inNumber;
    private Double result;

    public double getInNumber() {
        return inNumber;
    }

    public double getResult() {
        if (result == null) {
            resolveLogarithm();
        }
        return result;
    }

    public LogarithmNumber(double inNumber) {
        this.inNumber = inNumber;
    }

    public double resolveLogarithm() {
        return result = Math.log(this.inNumber);
    }
}
