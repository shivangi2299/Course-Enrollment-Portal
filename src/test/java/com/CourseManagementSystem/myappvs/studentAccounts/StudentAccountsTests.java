package com.CourseManagementSystem.myappvs.studentAccounts;

import com.CourseManagementSystem.myappvs.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentAccountsTests {

    @Mock
    private StudentAccountsRepository studentAccountsRepository;

    @InjectMocks
    private StudentAccountService studentAccountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudentAccountsDetail() {
        Long studentId = 1L;
        StudentAccounts studentAccounts = new StudentAccounts();
        studentAccounts.setStudentAccountsId(studentId);
        studentAccounts.setBalance(100.0);

        when(studentAccountsRepository.findByStudentId_studentIdNumber(studentId)).thenReturn(Optional.of(studentAccounts));

        StudentAccountDto result = studentAccountService.getStudentAccountsDetail(studentId);

        assertNotNull(result);
        assertEquals(studentId, result.getStudentAccountsId());
        assertEquals(100.0, result.getBalance());
    }

    @Test
    void testGetStudentAccountsDetail_StudentNotFound() {
        Long studentId = 1L;

        when(studentAccountsRepository.findByStudentId_studentIdNumber(studentId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            studentAccountService.getStudentAccountsDetail(studentId);
        });
    }

    @Test
    void testUpdateBalanceOnEnrollment() {
        Long studentId = 1L;
        double balanceUpdateAmount = 50.0;
        Long courseId = 1L;

        StudentAccounts studentAccounts = new StudentAccounts();
        studentAccounts.setStudentAccountsId(studentId);
        studentAccounts.setBalance(100.0);

        when(studentAccountsRepository.findByStudentId_studentIdNumber(studentId)).thenReturn(Optional.of(studentAccounts));

        studentAccountService.updateBalanceOnEnrollment(studentId, balanceUpdateAmount, courseId);

        assertEquals(50.0, studentAccounts.getBalance());
        verify(studentAccountsRepository, times(2)).save(studentAccounts);
    }

    @Test
    void testUpdateBalanceOnEnrollment_StudentAccountNotFound() {
        Long studentId = 1L;
        double balanceUpdateAmount = 50.0;
        Long courseId = 1L;

        when(studentAccountsRepository.findByStudentId_studentIdNumber(studentId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            studentAccountService.updateBalanceOnEnrollment(studentId, balanceUpdateAmount, courseId);
        });
    }

    @Test
    void testCreateStudentAccount() {
        Student student = new Student();
        student.setStudentIdNumber(1L);

        studentAccountService.createStudentAccount(student);

        verify(studentAccountsRepository, times(1)).save(any(StudentAccounts.class));
    }

    @Test
    void testRevertBalanceOnEnrollmentDeletion() {
        Long studentId = 1L;
        double amount = 50.0;
        Long courseId = 1L;

        StudentAccounts studentAccounts = new StudentAccounts();
        studentAccounts.setStudentAccountsId(studentId);
        studentAccounts.setBalance(100.0);

        when(studentAccountsRepository.findByStudentId_studentIdNumber(studentId)).thenReturn(Optional.of(studentAccounts));

        studentAccountService.revertBalanceOnEnrollmentDeletion(studentId, amount, courseId);

        assertEquals(150.0, studentAccounts.getBalance());
        verify(studentAccountsRepository, times(1)).save(studentAccounts);
    }

    @Test
    void testRevertBalanceOnEnrollmentDeletion_StudentAccountNotFound() {
        Long studentId = 1L;
        double amount = 50.0;
        Long courseId = 1L;

        when(studentAccountsRepository.findByStudentId_studentIdNumber(studentId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            studentAccountService.revertBalanceOnEnrollmentDeletion(studentId, amount, courseId);
        });
    }
}
