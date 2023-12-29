package com.example.anotationbaswork.model;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Coder {

    @Autowired
    Dog dog;
    public  Coder(){
        System.out.println("Coder object created");
    }
    public void petInfo(){
     dog.Info();
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Coder object destroy");
    }
}
