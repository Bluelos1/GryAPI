package com.example.gryapi.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GryapiDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(GryapiDataApplication.class, args);
    }

}
