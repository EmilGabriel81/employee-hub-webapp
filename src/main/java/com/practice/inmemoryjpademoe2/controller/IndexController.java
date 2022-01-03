package com.practice.inmemoryjpademoe2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping("/")
    public String showIndex(Model model){
        LocalDateTime now = LocalDateTime.now();
        String time = now.toString();
        System.out.println("The time on server is -"+time);
        model.addAttribute("dateTime", time);
        return "index.html";
    }

}
