package com.CourseManagementSystem.myappvs.security.Auth;

import com.CourseManagementSystem.myappvs.security.Controller.AuthenticationResponse;
import com.CourseManagementSystem.myappvs.security.Controller.Authenticationrequest;
import com.CourseManagementSystem.myappvs.security.Controller.Registerrequest;
import com.CourseManagementSystem.myappvs.security.Service.Jwtservice;
import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import com.CourseManagementSystem.myappvs.studentAccounts.StudentAccountService;
import com.CourseManagementSystem.myappvs.user.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        @Autowired
        private final Studentrepository srepository;
        @Autowired
        private  final StudentAccountService studentAccountService;
        @Autowired
        private final PasswordEncoder passwordEncoder;
        @Autowired
        private final Jwtservice jwtService;
        @Autowired
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(Registerrequest request) {
                var student = Student.builder()
                                .name(request.getName())
                                .emailId(request.getEmailId())
                                .studentIdNumber(request.getStudentIdNumber())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .number(request.getNumber())
                                .build();
                srepository.save(student);
                /*
                 * var user = User.builder()
                 * .emailId(request.getEmailId())
                 * .password(passwordEncoder.encode(request.getPassword()))
                 * .role(Role.USER)
                 * .build();
                 * urepository.save(user);
                 */
                studentAccountService.createStudentAccount(student);
                var jwtToken = jwtService.generateToken(student);
                return AuthenticationResponse.builder().token(jwtToken).build();
        }

        public AuthenticationResponse authenticate(Authenticationrequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmailId(), request.getPassword()));
                var user = srepository.findByEmailId(request.getEmailId())
                                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder().token(jwtToken).build();
        }
}
