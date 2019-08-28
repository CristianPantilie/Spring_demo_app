package com.salutlume.salutlume.UserStuff;

import com.salutlume.salutlume.Repositories.UserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Scope("session")
//@SessionAttributes("user")
public class LoginController {

//    private final UserRepository userRepository;
//
//    public LoginController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("/login")
    String login(Model model){
//        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/login")
     String validate(@ModelAttribute User user, Model model){

//        if(userRepository.findByUsername(user.getUsername()) != null){
//            return "redirect:/";
//        }
//
//        if(user.getUsername().equals("user") && user.getPassword().equals("parola")){
//
//        }
//        model.addAttribute("test", "login failure");

        return "redirect:/";
    }
}


