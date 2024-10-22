package com.example.btnjava.Controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping(value = "/login")
    public String showLogin() {
        return "login/login";
    }

    @GetMapping(value = "/register")
    public String showRegister() {
        return "signup/signup";
    }
}
