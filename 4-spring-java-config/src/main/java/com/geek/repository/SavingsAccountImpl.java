package com.geek.repository;

public class SavingsAccountImpl implements AccountRepository {

    public SavingsAccountImpl() {
        System.out.println("SavingsAccountImpl constructor called");
    }

    @Override
    public String creditFunds(float amt) {
        return "SavingsAccountImpl the amount " + amt + " has been credited to your account";
    }
}
