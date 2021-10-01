package com.Project.project2.web;

import com.Project.project2.service.userService;
import com.Project.project2.web.dto.userRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class userRegistrationController {

    private userService userService;

    public userRegistrationController(userService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new userRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") userRegistrationDto registrationDto){
        if (userService.verify(registrationDto.getEmail()))
            return "redirect:/registration?error";
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
