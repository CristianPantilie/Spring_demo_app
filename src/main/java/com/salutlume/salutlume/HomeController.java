package com.salutlume.salutlume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {

    private final GreetingRepository greetingRepo;

    HomeController(GreetingRepository greetingRepo){
        this.greetingRepo = greetingRepo;
    }

    @GetMapping("/")
    String hello(){
        return "Hello World";
    }

    @GetMapping("/greetings")
    Iterable<Greeting> greetings(){
        return greetingRepo.findAll();
    }
}
