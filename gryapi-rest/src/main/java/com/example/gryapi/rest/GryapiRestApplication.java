package com.example.gryapi.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.gryapi"})
public class GryapiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GryapiRestApplication.class, args);
    }

}
