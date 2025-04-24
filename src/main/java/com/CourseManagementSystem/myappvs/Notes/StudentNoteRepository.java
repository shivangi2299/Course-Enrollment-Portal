package com.CourseManagementSystem.myappvs.Notes;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StudentNoteRepository extends MongoRepository<StudentNote, String> {
    List<StudentNote> findByStudentEmail(String studentEmail);
    List<StudentNote> findByStudentEmailAndCourseId(String studentEmail, String courseId);
}