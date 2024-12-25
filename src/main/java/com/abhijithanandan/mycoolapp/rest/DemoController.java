package com.abhijithanandan.mycoolapp.rest;

import com.abhijithanandan.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
