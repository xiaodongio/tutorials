package com.dek.service;


import com.dek.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogService {

    @Autowired
    private LogDao logDao;
    @Autowired
    private OtherService otherService;

    @Transactional
    public void add(String content) {
        logDao.add(content);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add2(String content) {
        logDao.add(content);
    }


    public void saveError(String content) {
        /*
         * 日志的title长度为5 设置为11111111111111111是为了造成异常
         */
//        this.add("111111111111111111");
        throw new RuntimeException("saveError");


    }


}
