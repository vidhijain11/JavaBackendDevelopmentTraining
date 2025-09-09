package com.geek.client;

import com.geek.controller.AccountController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring Container is ready to use");
        AccountController controller = context.getBean(AccountController.class);
        String response = controller.creditFundsController(1000);
        System.out.println(response);
    }
}
