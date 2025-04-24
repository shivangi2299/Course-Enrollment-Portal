package com.CourseManagementSystem.myappvs.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {

    @GetMapping("/")
    public String redirectToIndex() {
        return "redirect:/index.html";
    }
}
