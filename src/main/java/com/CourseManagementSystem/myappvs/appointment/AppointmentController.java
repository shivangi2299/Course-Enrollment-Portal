package com.CourseManagementSystem.myappvs.appointment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    @Autowired
    private AppointmentService service;

    @GetMapping("/showall-student")
    public List<Appointment> getAppointments() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            return service.listByStudent(email);
        }
        return null;
    }

    @GetMapping("/showall-advisor/{id}")
    public List<Appointment> getAdvisorAppointments(@PathVariable String id) {
        Long advisorId = Long.parseLong(id);
        return service.listByAdvisor(advisorId);
    }

    @PostMapping("/bookAppointment")
    public ResponseEntity<Map<String, Object>> save(@RequestBody AppointmentRequest appointmentRequest) {
        System.out.println("received appt:"+appointmentRequest.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Long studentId = service.getStudentId(authentication.getName());
            Appointment add = Appointment.builder()
            .student(service.getStudentById(studentId))
            .advisor(service.getAdvisorById(appointmentRequest.getAdvisorId()))
            .appointmentDate(appointmentRequest.getAppointmentDate())
            .appointmentTime(appointmentRequest.getAppointmentTime())
            .appointmentNote(appointmentRequest.getNotes())
            .build();
            service.save(add);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()){
            Long apptId = Long.parseLong(id);
            service.delete(apptId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
