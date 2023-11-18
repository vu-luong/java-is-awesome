package com.vuluong.designpattern.builder.simple;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private final String email;
    private final boolean newsletter;

    private BankAccount(Builder builder) {
        this.name = builder.name;
        this.accountNumber = builder.accountNumber;
        this.email = builder.email;
        this.newsletter = builder.newsletter;
    }

    public static Builder builder(String name, String accountNumber) {
        return new Builder(name, accountNumber);
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public static class Builder {
        private final String name;
        private final String accountNumber;
        private String email;
        private boolean newsletter;

        public Builder(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder newsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }
}
