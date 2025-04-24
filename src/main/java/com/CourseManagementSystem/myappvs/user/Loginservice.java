package com.CourseManagementSystem.myappvs.user;

import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class Loginservice {

    @Autowired
    private Studentrepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Userserviceimpl userService;

    public Loginservice(Studentrepository studentRepository,
            PasswordEncoder passwordEncoder, Userserviceimpl userService) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public String login(Student student) throws Exception {
        Student existingUser = studentRepository.findByEmailId(student.getEmailId())
                .orElseThrow(() -> new Exception("Invalid credentials"));
        if (!passwordEncoder.matches(student.getPassword(), existingUser.getPassword())) {
            throw new Exception("Invalid credentials");
        }
        return existingUser.getStudent().getName();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student addUser(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Student getStudentByEmail(String emailId) {
        return studentRepository.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public UserDetailsService userDetailsService() {
        return (UserDetailsService) userService; // Return the Userserviceimpl directly
    }
}
