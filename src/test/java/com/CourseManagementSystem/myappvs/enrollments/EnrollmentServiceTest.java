package com.CourseManagementSystem.myappvs.enrollments;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.CourseManagementSystem.myappvs.courseCatalog.Catalog;
import com.CourseManagementSystem.myappvs.courseCatalog.CatalogRepository;
import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import com.CourseManagementSystem.myappvs.studentAccounts.StudentAccountService;

import jakarta.persistence.EntityManager;

@ExtendWith(MockitoExtension.class)
public class EnrollmentServiceTest {

    @Mock
    private Studentrepository studentRepo;

    @Mock
    private EnrollmentRepository enrollmentRepo;

    @Mock
    private CatalogRepository catalogRepo;

    @Mock
    private StudentAccountService studentAccountService;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private EnrollmentService enrollmentService;

    private Student student;
    private Catalog catalog;
    private Enrollment enrollment;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setStudentIdNumber(1L);
        student.setEmailId("test@example.com");

        catalog = new Catalog();
        catalog.setCourseId(1L);
        catalog.setCourseName("Test Course");

        enrollment = new Enrollment();
        enrollment.setId(1L);
        enrollment.setStudent(student);
        enrollment.setCatalog(catalog);
    }

    @Test
    void testEnrollStudent() {
        when(studentRepo.findByEmailId(anyString())).thenReturn(Optional.of(student));
        when(catalogRepo.findById(anyLong())).thenReturn(Optional.of(catalog));
        when(enrollmentRepo.findByStudent_StudentIdNumberAndCatalog_CourseId(anyLong(), anyLong())).thenReturn(Optional.empty());

        enrollmentService.enrollStudent("test@example.com", 1L);

        verify(enrollmentRepo, times(1)).save(any(Enrollment.class));
        verify(studentAccountService, times(1)).updateBalanceOnEnrollment(anyLong(), anyDouble(), anyLong());
    }

    @Test
    void testGetStudentEnrollment() {
        when(studentRepo.findByEmailId(anyString())).thenReturn(Optional.of(student));
        when(enrollmentRepo.findByStudent_StudentIdNumber(anyLong())).thenReturn(Arrays.asList(enrollment));

        List<Enrollment> enrollments = enrollmentService.getStudentEnrollment("test@example.com");

        assertEquals(1, enrollments.size());
        assertEquals("Test Course", enrollments.get(0).getCatalog().getCourseName());
    }

    @Test
    void testDeleteEnrollmentById() {
        when(enrollmentRepo.findById(anyLong())).thenReturn(Optional.of(enrollment));

        enrollmentService.deleteEnrollmentById(1L);

        verify(enrollmentRepo, times(1)).delete(any(Enrollment.class));
        verify(studentAccountService, times(1)).revertBalanceOnEnrollmentDeletion(anyLong(), anyDouble(), anyLong());
    }
}
