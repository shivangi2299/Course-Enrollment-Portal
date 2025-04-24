package com.CourseManagementSystem.myappvs.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import com.CourseManagementSystem.myappvs.studentAccounts.StudentAccountsRepository;

import jakarta.transaction.Transactional;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profile")
public class Profilecontroller {

    @Autowired
    private Studentrepository studentRepository;
    @Autowired
    private StudentAccountsRepository studentAccountRepository;

    @GetMapping
    public ResponseEntity<Map<String, Object>> showProfile() {
        // Retrieve authentication information from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();
            System.out.println("email id the user is " + emailId);

            // Fetch user profile using email
            Optional<Student> student = studentRepository.findByEmailId(emailId);
            if (student.isPresent()) {
                Student studentOp = student.get();
                // Construct a map to hold the profile data
                Map<String, Object> profileData = Map.of(
                        "emailId", studentOp.getEmailId(),
                        "name", studentOp.getName(),
                        "studentIdNumber", studentOp.getStudentIdNumber(),
                        "number", studentOp.getNumber());
                // Return the profile data as JSON response
                return ResponseEntity.ok(profileData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            // User is not authenticated
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody Student updatedStudent) {
        // Retrieve authentication information from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();

            // Fetch user profile using email
            Optional<Student> existingStudent = studentRepository.findByEmailId(emailId);
            if (existingStudent.isPresent()) {
                Student student = existingStudent.get();
                student.setName(updatedStudent.getName());
                student.setNumber(updatedStudent.getNumber());
                studentRepository.save(student);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            // User is not authenticated
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<?> deleteProfile() {
        // Retrieve authentication information from SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();

            // Fetch user profile using email
            Optional<Student> student = studentRepository.findByEmailId(emailId);
            if (student.isPresent()) {
                // Delete all student accounts related to the student
                studentAccountRepository.deleteByStudentId(student.get());

                studentRepository.delete(student.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            // User is not authenticated
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}