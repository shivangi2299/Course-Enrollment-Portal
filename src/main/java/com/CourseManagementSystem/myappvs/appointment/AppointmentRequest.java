package com.CourseManagementSystem.myappvs.appointment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter @NoArgsConstructor
public class AppointmentRequest {
    private Long advisorId;
    private String appointmentDate;
    private  String appointmentTime;
    private String notes;
}
