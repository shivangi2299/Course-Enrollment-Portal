package com.CourseManagementSystem.myappvs.courseDescription;

import com.CourseManagementSystem.myappvs.courseCatalog.Catalog;
import com.CourseManagementSystem.myappvs.instructor.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDescriptionDto {
    private Long courseDescriptionId;
    private Catalog courseId;
    private Instructor instructorId;
    private String room;

    private Date date;

    private Time time;

    private String meetingInfo;

    private String materials;
}
