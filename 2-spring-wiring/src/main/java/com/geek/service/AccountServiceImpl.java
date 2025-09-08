package com.geek.service;

import com.geek.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl constructor called");
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String creditFundsService(float amt) {
      return accountRepository.creditFunds(amt);
    }
}
