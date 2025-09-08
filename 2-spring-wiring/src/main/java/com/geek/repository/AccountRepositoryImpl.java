package com.geek.repository;

public class AccountRepositoryImpl implements AccountRepository {

    public AccountRepositoryImpl() {
        System.out.println("AccountRepositoryImpl constructor called");
    }

    @Override
    public String creditFunds(float amt) {
        return "The amount " + amt + " has been credited to your account";
    }
}
