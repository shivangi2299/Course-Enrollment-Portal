package com.CourseManagementSystem.myappvs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testcontroller {

    @RequestMapping("/test")
    @ResponseBody
    public String handle() {
        return "This is just for fun!!";
    }
    
//    @GetMapping("/")
//    public String showIndex() {
//    	return "index";
//    }

}
