package com.CourseManagementSystem.myappvs.studentAccounts;

import com.CourseManagementSystem.myappvs.student.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studentaccounts")
public class studentAccountsController {

    private StudentAccountService studentAccountService;

    @Autowired
    private Studentrepository studentRepo;

    public studentAccountsController(StudentAccountService studentAccountService) {
        this.studentAccountService = studentAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentAccountDto> getstudentAccountsbyId(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();
            System.out.println("email id the user is "+emailId);

            StudentAccountDto studentAccountDto = studentAccountService.getStudentAccountsDetail(id);
            return ResponseEntity.ok(studentAccountDto);


        }
       return null;
    }

    @PostMapping("/updateBalance")
    public ResponseEntity<StudentAccounts> updateBalance(@RequestBody StudentAccountDto request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String emailId = authentication.getName();

           double balanceUpdateAmount = request.getBalance();
           Long studentId = request.getStudentId().getStudentIdNumber();
           Long coursId= request.getCourseId().getCourseId();

            //studentAccountService.updateBalance(studentId, balanceUpdateAmount,courseId);

          studentAccountService.updateBalanceOnEnrollment(studentId,balanceUpdateAmount,coursId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/getId")
    public Long getStudentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String emailId = authentication.getName();
            return studentRepo.findIdByEmailId(emailId);
        }
        return null;
    }


}
