package com.chiragbohet.restfulwebservice1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

   @GetMapping("/hello")
    public String printWelcomeMessage()
    {
        return "Welcome to Spring Boot!";
    }
}
