package com.CourseManagementSystem.myappvs.courseCatalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CatalogServiceTest {

    @Mock
    private CatalogRepository catalogRepository;

    @InjectMocks
    private CatalogService catalogService;

    private Catalog catalog1;
    private Catalog catalog2;

    @BeforeEach
    void setUp() {
        catalog1 = new Catalog(1L, "Course 1", "Description 1", null, 3);
        catalog2 = new Catalog(2L, "Course 2", "Description 2", null, 4);
    }

    @Test
    void testGetAllCourses() {
        List<Catalog> catalogs = Arrays.asList(catalog1, catalog2);

        when(catalogRepository.findAll()).thenReturn(catalogs);

        List<Catalog> result = catalogService.getAllCourses();

        assertEquals(2, result.size());
        assertEquals("Course 1", result.get(0).getCourseName());
        assertEquals("Course 2", result.get(1).getCourseName());
    }
}
