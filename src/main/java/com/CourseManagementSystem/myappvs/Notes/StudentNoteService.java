 package com.CourseManagementSystem.myappvs.Notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentNoteService {

    @Autowired
    private StudentNoteRepository repository;

    public List<StudentNote> getNotesByStudentEmail(String studentEmail) {
        return repository.findByStudentEmail(studentEmail);
    }

    public List<StudentNote> getNotesByStudentEmailAndCourseId(String studentEmail, String courseId) {
        return repository.findByStudentEmailAndCourseId(studentEmail, courseId);
    }

    public StudentNote addOrUpdateStudentNote(StudentNote studentNote) {
        return repository.save(studentNote);
    }

    public void deleteStudentNoteById(String id) {
        repository.deleteById(id);
    }
}
