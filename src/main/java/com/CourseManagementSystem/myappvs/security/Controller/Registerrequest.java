package com.CourseManagementSystem.myappvs.security.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registerrequest {

    // For Student table
    private String name;
    private Long studentIdNumber;
    private String emailId;
    private String number;
    private String password;
}
