package com.CourseManagementSystem.myappvs.instructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    //Get Instructor Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getIndtructorbyId(@PathVariable Long id){

        try {
            InstructorDto instructorDto = instructorService.getInstructorDetail(id);
            return ResponseEntity.ok(instructorDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found
        }
    }
}
