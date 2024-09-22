package com.example.dd.dd.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Use @Controller to serve HTML files
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "User";
    }
}
