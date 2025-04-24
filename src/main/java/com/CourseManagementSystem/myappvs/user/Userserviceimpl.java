package com.CourseManagementSystem.myappvs.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CourseManagementSystem.myappvs.student.Studentrepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Userserviceimpl implements Userservice {
    private final Studentrepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmailId(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
            }
        };
    }
}