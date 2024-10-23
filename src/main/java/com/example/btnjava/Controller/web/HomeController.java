package com.example.btnjava.Controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String showRegister() {
        return "signup";
    }
}
