package com.geek.service;

import com.geek.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {

    @Autowired
    //@Qualifier("cc") // to specify which bean to inject when multiple beans of same type are present
    private AccountRepository accountRepository;

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl constructor called");
    }

    @Override
    public String creditFundsService(float amt) {
        return accountRepository.creditFunds(amt);
        //savings account will be injected since we have con figured account repository bean to return savingsAccountImpl.
    }
}
