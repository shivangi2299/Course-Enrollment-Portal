package com.CourseManagementSystem.myappvs.studentAccounts;

import com.CourseManagementSystem.myappvs.courseCatalog.Catalog;
import com.CourseManagementSystem.myappvs.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAccountDto {

    private Long studentAccountsId;

    private Student studentId;
    private Catalog courseId;

    private double balance;

}
