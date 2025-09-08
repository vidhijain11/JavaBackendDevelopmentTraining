package com.geek.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldBean bean= (HelloWorldBean) ctx.getBean("hellobean");
        System.out.println(bean.sayHello("Albin"));
 /* HelloWorldBean bean2= (HelloWorldBean) ctx.getBean("hellobean");
  System.out.println(bean==bean2);*/
    }
}
