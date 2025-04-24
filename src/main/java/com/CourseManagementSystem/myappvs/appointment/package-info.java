
/**
 * The appointment entity
 * 
 * The package appointment consists of the following classes:
 * 
 * The Entity class: 
 * <li>Many to one relationship between appointment and student
 * <li>Many to one relationship between appointment and advisor
 * 
 * Repository class:
 * To find appointments based on the fields in the entity. Extra finders such as
 * find all appointments by advisor id have also been implemented as an abstract method.
 * 
 *Appointment Service 
 The service layer of the appointment handles the CRUD operations for appointments.
 *
 * Appointment Controller:
 * A rest controller to manipulate the view. Endpoint serves both the student and admin users.
 * 
 * Apppointment Request class:
 * A data transfer object (DTO) to share appointment requests between the view and controller. A simple data object is
 * easy to create on the view side and furhtermore, the controller doesn't have to give up the references of the corrseponding
 * entities.
 * @author Guntaka Satish Harshavardhan Reddy
 */
package com.CourseManagementSystem.myappvs.appointment;
