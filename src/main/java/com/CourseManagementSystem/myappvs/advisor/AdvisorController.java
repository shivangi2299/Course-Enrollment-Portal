package com.CourseManagementSystem.myappvs.advisor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advisors")
public class AdvisorController {
    
    @Autowired
    private AdvisorRepository advisorRepo;
    
    @GetMapping("/all")
    public List<Advisor> listAdvisors() {
        return advisorRepo.findAll();
    }
}
