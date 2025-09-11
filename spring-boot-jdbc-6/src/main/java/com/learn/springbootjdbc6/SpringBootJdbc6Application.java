package com.learn.springbootjdbc6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class SpringBootJdbc6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbc6Application.class, args);
        // run method will initialize the spring container. Scans the classpath and create the beans for all component classes.
    }

}
