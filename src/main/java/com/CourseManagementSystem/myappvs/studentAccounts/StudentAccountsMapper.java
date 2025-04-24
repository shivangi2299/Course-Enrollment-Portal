package com.CourseManagementSystem.myappvs.studentAccounts;

public class StudentAccountsMapper {


    public static StudentAccounts maptoStudentAccounts(StudentAccountDto studentAccountDto){
        StudentAccounts studentAccounts = new StudentAccounts(
                studentAccountDto.getStudentAccountsId(),
                studentAccountDto.getStudentId(),
                studentAccountDto.getCourseId(),
                studentAccountDto.getBalance()

        );
        return studentAccounts;
    }
    public static StudentAccountDto maptoStudentAccountDto(StudentAccounts studentAccounts){
        StudentAccountDto studentAccountDto= new StudentAccountDto(
                studentAccounts.getStudentAccountsId(),
                studentAccounts.getStudentId(),
                studentAccounts.getCourseId(),
                studentAccounts.getBalance()

        );
        return studentAccountDto;
    }
}



