package com.usbank.hackathon.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.usbank.hackathon")

@SpringBootApplication
public class StartWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartWebApplication.class, args);
    }

}