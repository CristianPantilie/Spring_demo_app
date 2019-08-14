package com.salutlume.salutlume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final GreetingRepository greetingRepo;

    HomeController(GreetingRepository greetingRepo){
        this.greetingRepo = greetingRepo;
    }

    @GetMapping("/")
    String hello(Model model)
    {
        model.addAttribute("greetingSubmission", new Greeting());
        return "home";
    }

    @PostMapping("/")
    String insertGreetings(@ModelAttribute Greeting greetingSubmission, Model model){
        model.addAttribute("greetingSubmission", greetingSubmission);
        model.addAttribute("name", "Submission added!");
        greetingRepo.save(greetingSubmission);

        return "home";
    }

    @GetMapping("/greetings")
     String greetings(Model model){
        Iterable<Greeting> greetings = greetingRepo.findAll();

        model.addAttribute("greetings", greetings);

        return "greetings";
    }

//    @GetMapping("/greetings")
//    Iterable<Greeting> greetings(){
////        Iterable<Greeting> greetings = greetingRepo.findAll();
////
////        model.addAttribute("greeting", greetings);
//
//        return greetingRepo.findAll();
//    }

}
