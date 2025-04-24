package com.CourseManagementSystem.myappvs.user;

import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    private Studentrepository studentRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Userserviceimpl userService;

    @InjectMocks
    private Loginservice loginservice;

    private Student student;
    private Student existingStudent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student();
        student.setEmailId("test@example.com");
        student.setPassword("password");

        existingStudent = new Student();
        existingStudent.setEmailId("test@example.com");
        existingStudent.setPassword("encodedPassword");
        existingStudent.setName("Test User");
    }

    @Test
    void loginInvalidCredentialsTest() {
        when(studentRepository.findByEmailId("test@example.com")).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            loginservice.login(student);
        });

        assertEquals("Invalid credentials", exception.getMessage());
        verify(studentRepository, times(1)).findByEmailId("test@example.com");
    }

    @Test
    void addStudentTest() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student savedStudent = loginservice.addStudent(student);

        assertNotNull(savedStudent);
        assertEquals("test@example.com", savedStudent.getEmailId());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void addUserTest() {
        student.setPassword("rawPassword");
        when(passwordEncoder.encode("rawPassword")).thenReturn("encodedPassword");
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student savedStudent = loginservice.addUser(student);

        assertNotNull(savedStudent);
        assertEquals("encodedPassword", savedStudent.getPassword());
        verify(passwordEncoder, times(1)).encode("rawPassword");
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void getStudentByEmailTest() {
        when(studentRepository.findByEmailId("test@example.com")).thenReturn(Optional.of(student));

        Student foundStudent = loginservice.getStudentByEmail("test@example.com");

        assertNotNull(foundStudent);
        assertEquals("test@example.com", foundStudent.getEmailId());
        verify(studentRepository, times(1)).findByEmailId("test@example.com");
    }

    @Test
    void getStudentByEmailNotFoundTest() {
        when(studentRepository.findByEmailId("test@example.com")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            loginservice.getStudentByEmail("test@example.com");
        });

        assertEquals("Student not found", exception.getMessage());
        verify(studentRepository, times(1)).findByEmailId("test@example.com");
    }

}
