package com.CourseManagementSystem.myappvs.instructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Instructor")
public class Instructor {

    @Id
    @Column(unique = true)
    private long instructorId;

    private String instructorName;


    private String instructorDescription;

    private Time meetingHours;

    private String instructorCabinLocation;

}