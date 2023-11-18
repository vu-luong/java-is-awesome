package com.vuluong.designpattern.builder.simple;

public class BuilderExample {

    public static void main(String[] args) {
        BankAccount newAccount = BankAccount
            .builder("Vu", "131224")
            .email("vubinhcht@gmail.com")
            .newsletter(true)
            .build();

        System.out.println("Name: " + newAccount.getName());
        System.out.println("AccountNumber: " + newAccount.getAccountNumber());
        System.out.println("Email: " + newAccount.getEmail());
        System.out.println("Newsletter interested?: " + newAccount.isNewsletter());
    }
}
