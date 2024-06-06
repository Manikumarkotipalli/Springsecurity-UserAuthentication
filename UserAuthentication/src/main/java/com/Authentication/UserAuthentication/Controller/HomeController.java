package com.Authentication.UserAuthentication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "adminhome";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "userhome";
    }
}
