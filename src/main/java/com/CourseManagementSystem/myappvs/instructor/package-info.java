
/**
 * The instructor entity
 *This entity consist information regarding instructor.
 * The key components include the Instructor entity, the InstructorRepository, the InstructorService,
 * the InstructorController, the InstructorDto, and the InstructorMapper.
 *
 * This package manages the instructor details, including fetching and displaying detailed information about each instructor
 *
 * Entity Class (Instructor.java):
 * Contains fields such as instructorId, instructorName, instructorDescription, meetingHours, and instructorCabinLocation.
 * Annotated with JPA annotations to define the table structure and relationships.
 *
 * Data Transfer Object (InstructorDto.java):
 * Simplifies data exchange between client and server.
 * Contains similar fields to Instructor entity for ease of mapping and use in the REST API.
 *
 * Repository Interface (InstructorRepository.java):
 * Extends JpaRepository to provide CRUD operations.
 * Contains a custom query method findByInstructorId(Long instructorId) to find instructor details by instructor ID.
 *
 * Service Class (InstructorService.java):
 * Implements the service layer for business logic related to instructor details.
 * Provides the logic for fetching instructor details using the repository.
 * Throws a RuntimeException if the instructor is not found.
 *
 * Controller (InstructorController.java):
 * Exposes REST API endpoints for instructor details.
 * Contains a GET endpoint /api/instructor/{id} to fetch instructor details by ID.
 * Handles exceptions and returns appropriate HTTP status codes.
 *
 * Mapper (InstructorMapper.java):
 *
 * Provides static methods to map between Instructor entity and InstructorDto.
 * Ensures a clear separation between entity and DTO for better manageability and data consistency.
 *
 * All the instructor details are displayed on course description page so that students are able to access those details.
 * @author Shivangi Patel
 */
package com.CourseManagementSystem.myappvs.instructor;
