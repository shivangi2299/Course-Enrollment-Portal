
/**
 * The advisor entity
 * <li>One to many relationship between advisor and appointment.
 * Advisors and appointment have a cyclic relation. To prevent failure due to 
 * infinite recursion on creating JSON, JsonBackReference is used. Therefore the advisor
 * is not serialized when student users fetch appointment records.
 *  
 * The advisor repository
 * An abstract repository to fetch advisor records. Using derived query methods to query various of advisors.
 * 
 * Advisor Controller:
 * Manages the view and model interaction of advisor entity. 
 * 
 * @author Guntaka Satish Harshavardhan Reddy
 */
package com.CourseManagementSystem.myappvs.advisor;
