package com.example.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping(path="/hello")
    public String sayHello(){

        System.err.println("------I am called");
        return "Hello World";
    }

}
