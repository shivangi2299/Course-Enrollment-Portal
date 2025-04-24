package com.CourseManagementSystem.myappvs.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstructorDto {
    private long instructorId;

    private String instructorName;


    private String instructorDescription;

    private Time meetingHours;

    private String instructorCabinLocation;
}
