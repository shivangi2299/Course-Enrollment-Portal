package com.CourseManagementSystem.myappvs.appointment;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseManagementSystem.myappvs.advisor.Advisor;
import com.CourseManagementSystem.myappvs.advisor.AdvisorRepository;
import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;

import jakarta.transaction.Transactional;


@Service
public class AppointmentService {
    
    @Autowired
    private Studentrepository studentRepository;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private AdvisorRepository advisorRepo;

    public List<Appointment> listByStudent(String email) {
        Optional<Student> student = studentRepository.findByEmailId(email);
        List<Appointment> appointments = appointmentRepo.findAllByStudent(student.get());
        return appointments;
    }

    public List<Appointment> listByAdvisor(Long advisorId) {
        List<Appointment> appointments = appointmentRepo.findAllByAdvisor_AdvisorId(advisorId);
        return appointments;
    }

    public Student getStudentById(Long id) {
        Optional<Student> s = studentRepository.findById(id);
        return s.get();
    }
    public Long getStudentId(String email) {
        Optional<Student> s = studentRepository.findByEmailId(email);
        Student x = s.get();
        long id = x.getStudentIdNumber();
        return id;
    }

    public Advisor getAdvisorById(Long id) {
        Optional<Advisor> a = advisorRepo.findById(id);
        return a.get();
    }
    public Appointment save(Appointment appointment) {
        appointmentRepo.save(appointment);
        return appointment;
    }

    @Transactional
    public void delete(long id) {
        appointmentRepo.deleteById(id);
    }
}
