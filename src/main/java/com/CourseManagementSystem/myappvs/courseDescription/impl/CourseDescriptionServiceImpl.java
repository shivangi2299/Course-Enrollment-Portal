package com.CourseManagementSystem.myappvs.courseDescription.impl;


import com.CourseManagementSystem.myappvs.courseDescription.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDescriptionServiceImpl implements CourseDescriptionService {


    private CourseDescriptionRepository courseDescriptionRepository;

    @Autowired
    public CourseDescriptionServiceImpl(CourseDescriptionRepository courseDescriptionRepository) {
        this.courseDescriptionRepository = courseDescriptionRepository;
    }

    @Override
    public CourseDescriptionDto getCourseDetail(Long courseId) {

        CourseDescription courseDescription= courseDescriptionRepository
                                .findByCourseId_CourseId(courseId)
                                .orElseThrow(()-> new RuntimeException("Course Doesn't Exist"));
        return CourseDescriptionMapper.maptoCourseDescriptionDto(courseDescription);
    }
}
