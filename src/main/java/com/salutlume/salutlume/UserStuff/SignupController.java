package com.salutlume.salutlume.UserStuff;

import com.salutlume.salutlume.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    public SignupController(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    String show(Model model){

        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping
    String createUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        userRepository.save(user);

        return "redirect:/login";
    }

}
