package com.CourseManagementSystem.myappvs.courseDescription;

import com.CourseManagementSystem.myappvs.courseCatalog.Catalog;
import com.CourseManagementSystem.myappvs.instructor.Instructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Course_Description")
public class CourseDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long courseDescriptionId;

    @Exclude
    @OneToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Catalog courseId;

    @Exclude
    @ManyToOne
    @JoinColumn(name = "instructorId", referencedColumnName = "instructorId")
    private Instructor instructorId;
    @Column(name = "room", nullable = false)
    private String room;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "time", nullable = false)
    private Time time;
    @Column(name = "meeting_info", nullable = false)
    private String meetingInfo;
    @Column(name = "materials", nullable = false)
    private String materials;


}
