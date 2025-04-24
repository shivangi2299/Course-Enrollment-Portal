package com.CourseManagementSystem.myappvs.studentAccounts;

import com.CourseManagementSystem.myappvs.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentAccountService {

    private StudentAccountsRepository studentAccountsRepository;

    @Autowired
    public StudentAccountService(StudentAccountsRepository studentAccountsRepository) {
        this.studentAccountsRepository = studentAccountsRepository;
    }


    public StudentAccountDto getStudentAccountsDetail(Long studentId) {
        StudentAccounts studentAccounts = studentAccountsRepository
                .findByStudentId_studentIdNumber(studentId)
                .orElseThrow(() -> new RuntimeException("Student Doesn't Exist"));
        return StudentAccountsMapper.maptoStudentAccountDto(studentAccounts);
    }

    @Transactional
    public void updateBalanceOnEnrollment(Long id, double balanceUpdateAmount, Long courseId) {
        StudentAccounts studentAccount = studentAccountsRepository.findByStudentId_studentIdNumber(id)
                .orElseThrow(() -> new IllegalArgumentException("Student account not found"));

        if (studentAccount != null) {
            studentAccount.setBalance(studentAccount.getBalance() - balanceUpdateAmount);
            studentAccountsRepository.save(studentAccount);
        } else {
            throw new RuntimeException("Student account not found");
        }
        studentAccountsRepository.save(studentAccount);
    }

    @Transactional
    public void createStudentAccount(Student student) {
        StudentAccounts studentAccount = new StudentAccounts();
        studentAccount.setStudentAccountsId(student.getStudentIdNumber());
        studentAccount.setStudentId(student);
        studentAccount.setBalance(0);
        studentAccountsRepository.save(studentAccount);
    }

    @Transactional
    public void revertBalanceOnEnrollmentDeletion(Long studentId, double amount, Long courseId) {
        StudentAccounts studentAccount = studentAccountsRepository.findByStudentId_studentIdNumber(studentId)
            .orElseThrow(() -> new IllegalArgumentException("Student account not found"));

        if (studentAccount != null) {
            studentAccount.setBalance(studentAccount.getBalance() + amount);
            studentAccountsRepository.save(studentAccount);
        } else {
            throw new RuntimeException("Student account not found");
        }
    }

}
