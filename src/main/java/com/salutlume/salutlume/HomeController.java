package com.salutlume.salutlume;

import com.salutlume.salutlume.Repositories.GreetingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class HomeController {

    private final GreetingRepository greetingRepo;

    HomeController(GreetingRepository greetingRepo){
        this.greetingRepo = greetingRepo;
    }

    @GetMapping("/")
    String hello(@RequestParam(required = false) String action, Model model, SessionStatus status)
    {
//        if(!model.containsAttribute("user"))
//            model.addAttribute("name", "Please log in");


        model.addAttribute("greetingSubmission", new Greeting());
        model.addAttribute("name", "");

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
    String greetings( Model model){

        Iterable<Greeting> greetings = greetingRepo.findAll();

        model.addAttribute("greetings", greetings);

        return "greetings";
    }



//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    String work(Model model){
//        model.addAttribute("name", "Login succesful");
//        return "home";
//    }

//    @GetMapping("/greetings")
//    Iterable<Greeting> greetings(){
////        Iterable<Greeting> greetings = greetingRepo.findAll();
////
////        model.addAttribute("greeting", greetings);
//
//        return greetingRepo.findAll();
//    }

}
