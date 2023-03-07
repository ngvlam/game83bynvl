package com.lam.game8_3;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MainController {
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
}
