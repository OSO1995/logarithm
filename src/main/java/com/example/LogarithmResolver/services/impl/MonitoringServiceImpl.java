package com.example.LogarithmResolver.services.impl;

import com.example.LogarithmResolver.model.InputParam;
import com.example.LogarithmResolver.jmx.LogarithmBase10orMore;
import com.example.LogarithmResolver.jmx.LogarithmBase10orMoreMBean;
import com.example.LogarithmResolver.services.interfaces.MonitoringService;
import org.springframework.stereotype.Service;

import javax.management.*;
import java.lang.management.ManagementFactory;

@Service
public class MonitoringServiceImpl implements MonitoringService {

    private LogarithmBase10orMoreMBean mbeanLogarithmBase10orMore;

    public MonitoringServiceImpl() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        registerMonitoringLogarithm10orMoreNBean();
    }

    private void registerMonitoringLogarithm10orMoreNBean() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        mbeanLogarithmBase10orMore = new LogarithmBase10orMore();
        String className = mbeanLogarithmBase10orMore.getClass().getName();
        ObjectName name = getObjectName(className);
        mbs.registerMBean(mbeanLogarithmBase10orMore, name);
    }

    private ObjectName getObjectName(String className) throws MalformedObjectNameException {
        int lastIndexPoint = className.lastIndexOf(".");
        StringBuilder stringBuilder = new StringBuilder(className.substring(0, lastIndexPoint));
        stringBuilder.append(":type=");
        stringBuilder.append(className.substring(lastIndexPoint + 1));

        return new ObjectName(stringBuilder.toString());
    }

    @Override
    public void registerLogarithmBase10orMore(InputParam input) {
        Double base = input.getBase();
        if (base > 10) {
            mbeanLogarithmBase10orMore.setCount(mbeanLogarithmBase10orMore.getCount() + 1);
        }
    }
}
