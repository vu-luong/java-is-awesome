package com.vuluong.designpattern.facade;

import java.math.BigDecimal;

public interface IAccount {
    void deposit(BigDecimal amount);
    
    void withdraw(BigDecimal amount);
    
    void transfer(IAccount toAccount, BigDecimal amount);
    
    int getAccountNumber();
}
