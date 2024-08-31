package com.abheist.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

    @Bean
    public String message() {
        System.out.println("Message: Hello World");
        return "Hello world!";
    }

    @Bean
    public String uppercaseMessage(MessageService messageService) {
        System.out.println("Creating Uppercase Bean");
        return messageService.uppercase();
    }

    @Bean
    public String lowercaseMessage(MessageService messageService) {
        System.out.println("Creating Lowercase Bean");
        return messageService.lowercase();
    }
}
