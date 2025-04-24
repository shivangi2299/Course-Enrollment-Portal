package com.CourseManagementSystem.myappvs.instructor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class InstructorTests {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorService instructorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetInstructorDetail_InstructorDoesNotExist() {
        // Given
        Long instructorId = 1L;

        when(instructorRepository.findByInstructorId(instructorId)).thenReturn(Optional.empty());

        // When / Then
        assertThrows(RuntimeException.class, () -> {
            instructorService.getInstructorDetail(instructorId);
        });
    }
}
