package com.example.anotationbaswork;

import com.example.anotationbaswork.model.Coder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AnotationBasWorkApplication {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(AnotationBasWorkApplication.class, args);
        Coder c1=context.getBean(Coder.class);
        c1.petInfo();
    }

}
