package com.CourseManagementSystem.myappvs.advisor;


import com.CourseManagementSystem.myappvs.appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "advisors")
public class Advisor {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    private String name;

    private String email;

    @Exclude
    @OneToMany(mappedBy = "advisor",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Appointment> appointments;
}
