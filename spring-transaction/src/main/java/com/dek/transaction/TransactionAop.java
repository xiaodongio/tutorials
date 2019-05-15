package com.dek.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

@Component
public class TransactionAop {

    @Autowired
    private TransactionMonitor monitor;

    private TransactionStatus status;

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        status = monitor.begin();
        joinPoint.proceed();
        monitor.commit(status);
    }

    public void afterThrowing() {
        monitor.rollback(status);
    }

}
