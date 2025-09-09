package com.geek.repository;

import org.springframework.stereotype.Component;

@Component
public class SavingsAccountImpl implements AccountRepository {

    public SavingsAccountImpl() {
        System.out.println("AccountRepositoryImpl constructor called");
    }

    @Override
    public String creditFunds(float amt) {
        return "The amount " + amt + " has been credited to your account";
    }
}
