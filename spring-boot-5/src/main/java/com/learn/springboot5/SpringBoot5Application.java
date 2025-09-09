package com.learn.springboot5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class SpringBoot5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot5Application.class, args);
        // run method will initialize the spring container. Scans the classpath and create the beans for all component classes.
    }

}
