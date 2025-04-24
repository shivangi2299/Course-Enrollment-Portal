package com.CourseManagementSystem.myappvs.courseDescription;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coursedescription")
public class CourseDescriptionController {

    private CourseDescriptionService courseDescriptionService;

    public CourseDescriptionController(CourseDescriptionService courseDescriptionService) {
        this.courseDescriptionService = courseDescriptionService;
    }
    @GetMapping("/testCD")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("CD Endpoint is working");
    }
    //Get CourseDetails Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<CourseDescriptionDto> getCourseDescriptionbyId(@PathVariable Long id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal


            try {
                CourseDescriptionDto courseDescriptionDto = courseDescriptionService.getCourseDetail(id);
                return ResponseEntity.ok(courseDescriptionDto);
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found
            }

        }
        return null;

}

}
