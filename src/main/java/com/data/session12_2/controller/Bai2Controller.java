package com.data.session12_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bai2Controller {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "This is a public endpoint.";
    }

    @GetMapping("/private/hello")
    public String privateHello() {
        return "This is a protected endpoint.";
    }
}