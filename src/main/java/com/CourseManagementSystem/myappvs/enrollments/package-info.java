/**
 * This Package consists of:
 * 
 * 1.Enrollment Entity:
 * This represents the table storing all the enrollments per student for each enrolled course
 * 
 * 2.Enrollment Repository
 * This is the JPA Repository class responsible to communicate with enrollment table in the Database.
 * 
 * 3.Enrollment Service
 * Service class the fetch student, catalog object and insert an enrollment record into the enrollment table after student enrolls particular course
 * 
 * 4.Enrollment Controller
 * Receives the request to post the enrollment of a student.
 * <li>One to one relationship between student and user.
 * 
 * 5. CourseEnrollmentRequest
 * A DTO object to receive the Enrollment Request
 * 
 * 6. enrollments.html (related Html file in Target folder)
 * This is the HTML file containing HTML, CSS, JavaScript code to send appropriate requests and to handle the responses. This is a completely dynamic page.
 * 
 * 
 * @author Puneeth Talluri
 */
package com.CourseManagementSystem.myappvs.enrollments;