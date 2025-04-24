package com.CourseManagementSystem.myappvs.profile;

import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfileControllerTest {

    @InjectMocks
    private Profilecontroller profileController;

    @Mock
    private Studentrepository studentRepository;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    @Test
    void testShowProfileAuthenticated() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(authentication.isAuthenticated()).thenReturn(true);
        when(authentication.getName()).thenReturn("test@example.com");

        Student student = new Student();
        student.setEmailId("test@example.com");
        student.setName("Test User");
        student.setStudentIdNumber((long) 12345);
        student.setNumber("1234567890");

        when(studentRepository.findByEmailId("test@example.com")).thenReturn(Optional.of(student));

        ResponseEntity<Map<String, Object>> response = profileController.showProfile();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("test@example.com", response.getBody().get("emailId"));
        assertEquals("Test User", response.getBody().get("name"));
    }

    @Test
    void testShowProfileNotAuthenticated() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(authentication.isAuthenticated()).thenReturn(false);

        ResponseEntity<Map<String, Object>> response = profileController.showProfile();

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    void testUpdateProfile() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(authentication.isAuthenticated()).thenReturn(true);
        when(authentication.getName()).thenReturn("test@example.com");

        Student existingStudent = new Student();
        existingStudent.setEmailId("test@example.com");
        existingStudent.setName("Old Name");
        existingStudent.setNumber("1234567890");

        Student updatedStudent = new Student();
        updatedStudent.setName("New Name");
        updatedStudent.setNumber("0987654321");

        when(studentRepository.findByEmailId("test@example.com")).thenReturn(Optional.of(existingStudent));

        ResponseEntity<?> response = profileController.updateProfile(updatedStudent);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(studentRepository).save(existingStudent);
        assertEquals("New Name", existingStudent.getName());
        assertEquals("0987654321", existingStudent.getNumber());
    }



}
