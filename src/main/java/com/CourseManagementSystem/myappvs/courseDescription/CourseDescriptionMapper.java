package com.CourseManagementSystem.myappvs.courseDescription;

public class CourseDescriptionMapper {
    public static CourseDescription maptoCourseDescription(CourseDescriptionDto courseDescriptionDto){
        CourseDescription courseDescription = new CourseDescription(
                courseDescriptionDto.getCourseDescriptionId(),
                courseDescriptionDto.getCourseId(),
                courseDescriptionDto.getInstructorId(),
                courseDescriptionDto.getRoom(),
                courseDescriptionDto.getDate(),
                courseDescriptionDto.getTime(),
                courseDescriptionDto.getMeetingInfo(),
                courseDescriptionDto.getMaterials()
        );
        return courseDescription;
    }
    public static CourseDescriptionDto maptoCourseDescriptionDto(CourseDescription courseDescription){
        CourseDescriptionDto courseDescriptionDto = new CourseDescriptionDto(
                courseDescription.getCourseDescriptionId(),
                courseDescription.getCourseId(),
                courseDescription.getInstructorId(),
                courseDescription.getRoom(),
                courseDescription.getDate(),
                courseDescription.getTime(),
                courseDescription.getMeetingInfo(),
                courseDescription.getMaterials()
        );
        return courseDescriptionDto;
    }
}
