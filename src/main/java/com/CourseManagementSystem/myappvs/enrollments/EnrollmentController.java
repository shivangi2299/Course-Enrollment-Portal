package com.CourseManagementSystem.myappvs.enrollments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CourseManagementSystem.myappvs.student.Student;

@RestController
@RequestMapping("enroll")
public class EnrollmentController {
    
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enrollCourse")
    public ResponseEntity<Map<String, Object>> enrollStudentInCourse(@RequestBody CourseEnrollmentRequest request) {
    	
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();
            System.out.println("Email id of student is :" + emailId);
            System.out.println("Enrollment Controller triggered");

            Long id = Long.parseLong(request.getCourseId());

            enrollmentService.enrollStudent(emailId, id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/test3")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Endpoint is working");
    }
    
    @GetMapping("/showEnrollments")
    public List<Enrollment> showEnrollments() {
        // Retrieve authentication information from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();
            System.out.println("email id the user is "+emailId);
           
            List<Enrollment> currentEnrollments=enrollmentService.getStudentEnrollment(emailId);
            return currentEnrollments;
            
            
        } 
        return null;
    }
    
    @DeleteMapping("/deleteEnrollment/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            enrollmentService.deleteEnrollmentById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
