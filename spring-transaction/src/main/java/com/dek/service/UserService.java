package com.dek.service;

import com.dek.dao.UserDao;
import com.dek.transaction.TransactionMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TransactionMonitor monitor;

	public void add1() {
		System.out.println(" userService add...");
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

}
