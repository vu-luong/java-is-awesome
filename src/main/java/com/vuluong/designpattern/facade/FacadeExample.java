package com.vuluong.designpattern.facade;

import java.math.BigDecimal;

public class FacadeExample {
    public static void main(String[] args) {
        BankService myBankService = new BankService();
        int mySaving = myBankService.createNewAccount("saving", new BigDecimal("500.00"));
        int myInvestment = myBankService.createNewAccount("investment", new BigDecimal("1000.00"));
        myBankService.transferMoney(mySaving, myInvestment, new BigDecimal("300.00"));
    }
}
