
/**
 * The courseDescription entity
 * This entity has detailed information regarding course which can be accessed after enrolling into the course.
 * The key components include the CourseDescription entity, the CourseDescriptionRepository,
 * the CourseDescriptionService interface and its implementation, the CourseDescriptionController,
 * the CourseDescriptionDto, and the CourseDescriptionMapper.
 * <li>One to one relationship between courseDescription and courseCatalog
 * <li>Many to one relationship between courseDescription and instructor
 *
 * Entity class (CourseDescription.java):
 * Contains fields such as courseDescriptionId, courseId (references Catalog),instructorId (references Instructor),
 * room, date, time, meetingInfo, and materials.
 * Annotated with JPA annotations to define the table structure and relationships.
 *
 * Data Transfer Object (CourseDescriptionDto.java):
 * Simplifies data exchange between client and server.
 * Contains similar fields to CourseDescription entity for ease of mapping and use in the REST API.
 *
 * Repository Interface (CourseDescriptionRepository.java):
 * Extends JpaRepository to provide CRUD operations.
 * Contains a custom query method findByCourseId_CourseId(Long courseId) to find course descriptions by course ID.
 *
 * Service Interface and Implementation (CourseDescriptionService.java and CourseDescriptionServiceImpl.java):
 * Defines the service layer interface for business logic related to course descriptions.
 * The implementation class provides the logic for fetching course details using the repository.
 *
 * Controller (CourseDescriptionController.java):
 * Exposes REST API endpoints for course descriptions.
 * Contains a GET endpoint /api/coursedescription/{id} to fetch course details by ID.
 * Handles exceptions and returns appropriate HTTP status codes.
 *
 * Mapper (CourseDescriptionMapper.java):
 * Provides static methods to map between CourseDescription entity and CourseDescriptionDto.
 *Ensures a clear separation between entity and DTO for better manageability and data consistency.
 *
 * For this page there is frontend page which displays details of course which is HTML file courseDescription.html
 * demonstrates how to use the REST API to fetch and display course details in a web page.
 *
 *Error handling is also done i.e.  The controller returns a 404 Not Found status if the course details are not found
 * The use of DTOs and mappers ensures that the data transfer between layers is consistent and decoupled from the database entity structure.
 * @author Shivangi Patel
 */
package com.CourseManagementSystem.myappvs.courseDescription;
