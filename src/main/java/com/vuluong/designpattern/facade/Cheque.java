package com.vuluong.designpattern.facade;

import java.math.BigDecimal;

public class Cheque implements IAccount {
    
    @Override
    public void deposit(BigDecimal amount) {}
    
    @Override
    public void withdraw(BigDecimal amount) {}
    
    @Override
    public void transfer(IAccount toAccount, BigDecimal amount) {}
    
    @Override
    public int getAccountNumber() {
        return 0;
    }
}
