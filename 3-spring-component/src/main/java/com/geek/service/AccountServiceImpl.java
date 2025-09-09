package com.geek.service;

import com.geek.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // use Qualifier to inject a specific implementation when multiple implementations are present
//    @Autowired
//    @Qualifier("serviceAccountImpl")
//    private AccountRepository accountRepository;

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl constructor called");
    }

//    @Autowired
//    public void setAccountRepository(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    @Override
    public String creditFundsService(float amt) {
      return accountRepository.creditFunds(amt);  //credit card account will be injected since its primary.
    }
}
