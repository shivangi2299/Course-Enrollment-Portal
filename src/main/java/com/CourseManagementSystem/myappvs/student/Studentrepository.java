package com.CourseManagementSystem.myappvs.student;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Studentrepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmailId(String emailId);
    
    @Query("SELECT s.name FROM Student s WHERE s.emailId = :emailId")
    String findNameByEmailId(@Param("emailId") String emailId);

    boolean existsByEmailId(String email);

    boolean existsByStudentIdNumber(Long studentIdNumber);
    @Query("SELECT s.studentIdNumber FROM Student s WHERE s.emailId = :emailId")
    Long findIdByEmailId(@Param("emailId") String emailId);
}