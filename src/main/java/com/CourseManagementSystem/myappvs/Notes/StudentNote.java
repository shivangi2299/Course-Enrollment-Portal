package com.CourseManagementSystem.myappvs.Notes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection = "student_notes")
public class StudentNote {

    @Id
    private String id;
    private String studentEmail;
    private String courseId;
    private String noteTitle;
    private String noteContent;

   
}
