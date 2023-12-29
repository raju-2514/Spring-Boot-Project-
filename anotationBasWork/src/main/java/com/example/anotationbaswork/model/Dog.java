package com.example.anotationbaswork.model;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    public Dog(){
        System.out.println("Dog object created");
    }
    public  void Info(){
        System.out.println("This is German shape dog");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Dog object Destroyed");
    }
}
