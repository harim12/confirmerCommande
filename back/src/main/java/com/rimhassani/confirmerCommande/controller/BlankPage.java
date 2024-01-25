package com.rimhassani.confirmerCommande.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlankPage {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, welcome to my Spring Boot application!";
    }
}