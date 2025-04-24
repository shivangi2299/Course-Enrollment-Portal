package com.CourseManagementSystem.myappvs.appointment;

import com.CourseManagementSystem.myappvs.advisor.Advisor;
import com.CourseManagementSystem.myappvs.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "appointments")
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long id;

    @Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "studentIdNumber")
    private Student student;
    
    @Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advisorId", referencedColumnName = "advisorId")
    @JsonManagedReference
    private Advisor advisor;

    @Temporal(TemporalType.DATE)
    private String appointmentDate;

    @Temporal(TemporalType.TIME)
    private String appointmentTime;

    private String appointmentNote;
}
