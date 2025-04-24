
/**
 * The studentAccounts entity
 * This entity represents the balance of student after enrolling into the course.
 * The main components include the StudentAccounts entity, the StudentAccountDto, the StudentAccountsRepository,
 * the StudentAccountService,the StudentAccountsController, and the StudentAccountsMapper.
 * <li>One to one relationship between studentAccounts and student
 *
 *This package manages the details of student accounts, including fetching and displaying information about each student’s account
 *Entity Class (StudentAccounts.java):
 * Contains fields such as studentAccountsId, studentId, and balance.
 * Annotated with JPA annotations to define the table structure and relationships.
 * The studentId field is a foreign key linked to the Student entity.
 *
 * Data Transfer Object (StudentAccountDto.java):
 *
 * Simplifies data exchange between client and server.
 * Contains similar fields to the StudentAccounts entity for ease of mapping and use in the REST API.
 * Includes fields for studentAccountsId, studentId, and balance.
 *
 * Repository Interface (StudentAccountsRepository.java):
 *
 * Extends JpaRepository to provide CRUD operations.
 * Contains a custom query method findByStudentId_studentIdNumber(Long studentId) to find student account details by student ID.
 *
 * Service Class (StudentAccountService.java):
 *
 * Implements the service layer for business logic related to student account details.
 * Provides the logic for fetching student account details using the repository.
 * Throws a RuntimeException if the student account is not found.
 *
 * Controller (StudentAccountsController.java):
 *
 * Exposes REST API endpoints for student account details.
 * Contains a GET endpoint /api/studentaccounts/{id} to fetch student account details by ID.
 * Handles exceptions and returns appropriate HTTP status codes.
 *
 * Mapper (StudentAccountsMapper.java):
 *
 * Provides static methods to map between StudentAccounts entity and StudentAccountDto.
 * Ensures a clear separation between entity and DTO for better manageability and data consistency.
 *
 * For front-end, the html page is created named studentAccounts.html which displays student accounts. Which can directly accessed using Home page.
 *  The controller returns a 404 Not Found status if the student account details are not found, ensuring appropriate client feedback.
 *
 * @author Shivangi Patel
 */
package com.CourseManagementSystem.myappvs.studentAccounts;
