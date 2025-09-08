package com.geek.bean;

public class HelloWorldBean {
    private String msg;
    public void setMsg(String msg) {
        this.msg = msg;
        System.out.println("setter");
    }

    public HelloWorldBean(String msg, String msg2) {
        System.out.println("constructor" +msg2);
        this.msg=msg;
    }
    public String sayHello(String name) {
        return "Hi "+name+" "+msg;
    }
}

