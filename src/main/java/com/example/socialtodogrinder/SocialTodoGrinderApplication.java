package com.example.socialtodogrinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SocialTodoGrinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialTodoGrinderApplication.class, args);
    }

}
