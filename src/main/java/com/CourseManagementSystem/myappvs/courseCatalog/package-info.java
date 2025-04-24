/**
 * This Package consists : 
 * 1.Catalog Entity:
 * This entity represents the table storing all the Courses and its respective information to be displayed to students for them to be able to enroll.
 * 
 * 2.Catalog Controller
 * This is the controller class which is responsible to get the requests and display the Courses in the courseCatalog page. It displays a table and allows enrollment for each course.
 * 
 * 3.Course Service
 * This is the service class where I make use of the repository to write the logic to fetch the data and return it from the H2 Database. 
 * 
 * 4.Course Repository
 * This is the JPA Repository class which is used to retrieve the course_catalog table information from the H2 DataBase. 
 * 
 * 5. courseCatalog.html 
 * This is the HTML file containing HTML, CSS, Javascript code to send appropriate requests and to handle the responses.
 * 
 
 * 
 * @author Puneeth Talluri
 */
package com.CourseManagementSystem.myappvs.courseCatalog;
