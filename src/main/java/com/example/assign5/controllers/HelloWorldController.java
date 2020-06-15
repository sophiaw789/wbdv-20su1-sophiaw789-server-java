package com.example.assign5.controllers;

import com.example.assign5.models.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/api/hello/{message}")
    public HelloModel sayHello(
        @PathVariable("message") String msg) {
            //does work
            HelloModel hello = new HelloModel(msg, 123);
            return hello;
        }
}