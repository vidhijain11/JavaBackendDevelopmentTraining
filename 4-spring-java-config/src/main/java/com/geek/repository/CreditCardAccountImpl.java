package com.geek.repository;

public class CreditCardAccountImpl implements AccountRepository {

    public CreditCardAccountImpl() {
        System.out.println("CreditCardAccountImpl constructor called");
    }

    @Override
    public String creditFunds(float amt) {
        return "CreditCardAccountImpl the amount " + amt + " has been credited to your credit card account";
    }
}
