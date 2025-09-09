package com.geek.controller;

import com.geek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountController {

    private AccountService accountService;

    public AccountController() {
        System.out.println("AccountController constructor called");
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String creditFundsController(float amt) {
        System.out.println("AccountController: creditFundsController called with amount: " + amt);
        return accountService.creditFundsService(amt);
    }

}
