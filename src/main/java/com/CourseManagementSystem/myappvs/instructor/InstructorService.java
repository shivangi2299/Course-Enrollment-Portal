package com.CourseManagementSystem.myappvs.instructor;


import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    private InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    public InstructorDto getInstructorDetail(Long instructorId) {
        Instructor instructor = instructorRepository
                .findByInstructorId(instructorId)
                .orElseThrow(()-> new RuntimeException("Instructor Doesn't Exist"));
        return InstructorMapper.maptoInstructorDto(instructor);
    }
}
