package com.tmehulic.designpatterns.strategy.spring.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Transactional
    public void executeTransaction() {
        System.out.println("Exception should be thrown here!");
    }
}
