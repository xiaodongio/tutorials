package com.dek.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class TransactionMonitor {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    public TransactionStatus begin() {
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
        System.out.println("transaction begin");
        return transaction;
    }

    public void commit(TransactionStatus transaction) {
        dataSourceTransactionManager.commit(transaction);
        System.out.println("transaction commit");
    }

    public void rollback(TransactionStatus transaction) {
        dataSourceTransactionManager.rollback(transaction);
        System.out.println("transaction rollback");
    }

}
