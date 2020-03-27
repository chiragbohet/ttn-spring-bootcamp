package com.chiragbohet.RESTfulwebservices2.Controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Api(value = "/greeting/{name}",description = "Supports good morning in Swedish, German and English (default)")
@RestController
public class GreetingController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/greeting/{name}")
    public String sayHello(@RequestHeader(name = "Accept-Language", required = false)Locale locale, @PathVariable String name){
        return messageSource.getMessage("good.morning.message",null,locale) + " " +name + "!";
    }
}
