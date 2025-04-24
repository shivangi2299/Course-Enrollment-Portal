package com.CourseManagementSystem.myappvs.security.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authenticationrequest {

    private String emailId;
    String password;
}
