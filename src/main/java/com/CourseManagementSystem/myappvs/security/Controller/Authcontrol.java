package com.CourseManagementSystem.myappvs.security.Controller;

import com.CourseManagementSystem.myappvs.security.Auth.AuthenticationService;
import com.CourseManagementSystem.myappvs.security.Service.Jwtservice;
import com.CourseManagementSystem.myappvs.student.Studentrepository;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class Authcontrol {
    // private final AuthenticationManager authenticationManager;
    // private final Loginservice loginService;
    // private final Jwtservice jwtService;

    private final AuthenticationService service;
    @Autowired
    private Studentrepository studentRepository;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signup(@RequestBody Registerrequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Authenticationrequest request) throws Exception {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmailExists(@RequestParam("email") String email) {
        boolean exists = studentRepository.existsByEmailId(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-student-id")
    public ResponseEntity<Map<String, Boolean>> checkStudentIdExists(@RequestParam("studentId") String studentId) {
        boolean exists = studentRepository.existsByStudentIdNumber(Long.valueOf(studentId));
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }

}