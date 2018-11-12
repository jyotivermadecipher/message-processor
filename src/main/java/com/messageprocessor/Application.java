package com.messageprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @implNote : Entry point for Message Application
 */
@SpringBootApplication(scanBasePackages = {Constants.BASE_PACKAGE})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
