package com.CourseManagementSystem.myappvs.courseDescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseDescriptionRepository extends JpaRepository<CourseDescription , Long> {

     Optional<CourseDescription> findByCourseId_CourseId(Long courseId);

}
