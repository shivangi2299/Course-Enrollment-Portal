package com.CourseManagementSystem.myappvs.Notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.CourseManagementSystem.myappvs.student.Studentrepository;

import java.util.List;

@RestController
@RequestMapping("/studentNotes")
public class StudentNoteController {

    @Autowired
    private StudentNoteService service;
    
//    @Autowired
//    private Studentrepository sturepo;

    @GetMapping
    public List<StudentNote> getNotesByStudentEmail() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();
    	
        return service.getNotesByStudentEmail(emailId);
        }
        return null;
    }

    @GetMapping("/{studentEmail}/{courseId}")
    public List<StudentNote> getNotesByStudentEmailAndCourseId(@PathVariable String studentEmail, @PathVariable String courseId) {
        return service.getNotesByStudentEmailAndCourseId(studentEmail, courseId);
    }

    @PostMapping
    public StudentNote addOrUpdateStudentNote(@RequestBody StudentNote studentNote) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String emailId = authentication.getName();
            studentNote.setStudentEmail(emailId);
        }
        return service.addOrUpdateStudentNote(studentNote);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentNoteById(@PathVariable String id) {
        service.deleteStudentNoteById(id);
    }
}