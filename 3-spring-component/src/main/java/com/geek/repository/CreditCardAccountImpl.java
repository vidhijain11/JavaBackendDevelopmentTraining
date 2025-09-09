package com.geek.repository;

import com.geek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CreditCardAccountImpl implements AccountRepository {

    public CreditCardAccountImpl() {
        System.out.println("CreditCardAccountImpl constructor called");
    }

    @Override
    public String creditFunds(float amt) {
        return "The amount " + amt + " has been credited to your credit card account";
    }
}
