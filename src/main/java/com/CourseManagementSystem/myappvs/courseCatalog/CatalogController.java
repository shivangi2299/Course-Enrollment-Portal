package com.CourseManagementSystem.myappvs.courseCatalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourseManagementSystem.myappvs.student.Studentrepository;

@RestController
public class CatalogController {
	
	@Autowired
	private CatalogService service;
	
	@Autowired
	private Studentrepository stuRepo;
	
	
	@GetMapping("/getCourses")
	private List<Catalog> displayCourses(){
		return service.getAllCourses();
	}
	
	 @GetMapping("/getName")
	    public String getStudentName() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        if (authentication != null && authentication.isAuthenticated()) {
	            String emailId = authentication.getName();
	            return stuRepo.findNameByEmailId(emailId);
	        }
	        return "User";
	    }
	
	

}
