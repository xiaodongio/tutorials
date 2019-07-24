package com.dek.service;

import com.dek.dao.UserDao;
import com.dek.transaction.TransactionMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionMonitor monitor;
	@Autowired
	private LogService logService;
	@Autowired
	private OtherService otherService;

	public void add1() {
		System.out.println(" userService add1...");
		TransactionStatus begin = null;
		try {
			begin = monitor.begin();
			userDao.add("dek", 18);
			int i = 1/0;
			monitor.commit(begin);
		} catch (Exception e) {
			e.printStackTrace();
			monitor.rollback(begin);
		}
	}

    public void add2() {
        System.out.println(" userService add2...");
        userDao.add("dek", 18);
        int i = 1/0;
    }


    public void testData() {
		userDao.testData(10000);
	}


	@Transactional
	public void add(String name, Integer age) {
		userDao.add(name, age);
	}



	@Transactional(noRollbackFor = {RuntimeException.class, Exception.class})
	public void save(String name, Integer age) throws Exception {
		try {
			this.add(name, age);
			handleSms();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if (e instanceof RuntimeException) {
				logService.add2("123");
			}

		}

	}



	public void handleSms() {
//		otherService.test();

		logService.saveError("123123123211");

	}





}
