package com.CourseManagementSystem.myappvs.courseDescription;

import com.CourseManagementSystem.myappvs.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;
}
