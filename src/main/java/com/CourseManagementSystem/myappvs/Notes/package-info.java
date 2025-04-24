/**
 * This Package consists of the Student Notes section which uses MongoDB. The main functionality of this section is that it enables
 * the students to create course specific notes and allows them to be managed. The various parts of this section are 
 * 
 * 
 * 1.StudentNote.java
 * This entity represents the document storing the note Information such as Student emailId, CourseID Note Title, Note Description.
 * 
 * 2.Catalog Controller
 * The Controller class deals with GET, POST, DELETE Mapping of requests in this scenario.
 * 
 * 3.Course Service
 * THis is the service class where I make use of the repository to write the logic to fetch the data and return it.
 * 
 * 4.Course Repository
 * This is the Interface which extends MongoRepository which is used to retrieve the Students Notes from the online Mongo Atlas configured in the application.properties
 * 
 * 5. studentNotes.html 
 * The HTML file contains front end code to send requests and to handle responses. 
 * 
 * 
 * @author Puneeth Talluri
 */
package com.CourseManagementSystem.myappvs.Notes;