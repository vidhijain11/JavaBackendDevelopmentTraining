package com.geek.config;

import com.geek.controller.AccountController;
import com.geek.repository.AccountRepository;
import com.geek.repository.CreditCardAccountImpl;
import com.geek.repository.SavingsAccountImpl;
import com.geek.service.AccountService;
import com.geek.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class SpringConfig {

    @Bean //replacing <bean> in XML
    public AccountController getAccountController() {
        return new AccountController();
    }

    @Bean //replacing <bean> in XML
    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }

    @Bean
    @Primary // to resolve ambiguity when multiple beans of same type are present or use Qualifier
    public AccountRepository getSavingsAccountImpl() {
        return new SavingsAccountImpl();
    }

    @Bean("cc")
    public AccountRepository getCreditCardAccountImpl() {
        return new CreditCardAccountImpl();
    }
}
