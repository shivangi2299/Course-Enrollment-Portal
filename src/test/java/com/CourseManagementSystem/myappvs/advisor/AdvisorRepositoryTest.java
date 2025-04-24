package com.CourseManagementSystem.myappvs.advisor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CourseManagementSystem.myappvs.advisor.Advisor;
import com.CourseManagementSystem.myappvs.advisor.AdvisorRepository;

@SpringBootTest
public class AdvisorRepositoryTest {
    
    @Autowired
    private AdvisorRepository advisorRepository;

    @Test
    public void testRepo() {
        Advisor advisorDoe = new Advisor();
        advisorDoe.setName("Doe");
        advisorDoe.setEmail("doe@test.com");
        Long repoCountBefore = advisorRepository.count();
        
        advisorRepository.save(advisorDoe);
        Long advisorDoeId = advisorDoe.getAdvisorId();
        assertEquals(repoCountBefore+1, advisorRepository.count());

        Advisor advisor = advisorRepository.findById(advisorDoeId).orElse(new Advisor());
        assertEquals(advisorDoeId, advisor.getAdvisorId());

        advisorRepository.delete(advisorDoe);
        assertEquals(repoCountBefore, advisorRepository.count());
    }
}
