package com.example.LogarithmResolver.jmx;

import org.springframework.stereotype.Component;

@Component
public class LogarithmBase10orMore implements LogarithmBase10orMoreMBean {

    private int count;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }
}
