package com.CourseManagementSystem.myappvs.courseDescription;

import com.CourseManagementSystem.myappvs.courseCatalog.Catalog;
import com.CourseManagementSystem.myappvs.courseDescription.impl.CourseDescriptionServiceImpl;
import com.CourseManagementSystem.myappvs.instructor.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Time;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CourseDescriptionTests {

    @Mock
    private CourseDescriptionRepository courseDescriptionRepository;

    @InjectMocks
    private CourseDescriptionServiceImpl courseDescriptionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCourseDetail() {
        // Given
        Long courseId = 1L;
        Catalog catalog = new Catalog();
        catalog.setCourseId(courseId);
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        CourseDescription courseDescription = new CourseDescription(
                1L,
                catalog,
                instructor,
                "Room 101",
                new Date(),
                new Time(System.currentTimeMillis()),
                "Weekly meeting",
                "Books and notebooks"
        );

        when(courseDescriptionRepository.findByCourseId_CourseId(courseId)).thenReturn(Optional.of(courseDescription));

        // When
        CourseDescriptionDto result = courseDescriptionService.getCourseDetail(courseId);

        // Then
        assertNotNull(result);
        assertEquals(courseDescription.getCourseDescriptionId(), result.getCourseDescriptionId());
        assertEquals(courseDescription.getRoom(), result.getRoom());
        assertEquals(courseDescription.getDate(), result.getDate());
        assertEquals(courseDescription.getTime(), result.getTime());
        assertEquals(courseDescription.getMeetingInfo(), result.getMeetingInfo());
        assertEquals(courseDescription.getMaterials(), result.getMaterials());
    }

    @Test
    public void testGetCourseDetail_CourseDoesNotExist() {
        // Given
        Long courseId = 1L;

        when(courseDescriptionRepository.findByCourseId_CourseId(courseId)).thenReturn(Optional.empty());

        // When / Then
        assertThrows(RuntimeException.class, () -> {
            courseDescriptionService.getCourseDetail(courseId);
        });
    }
}
