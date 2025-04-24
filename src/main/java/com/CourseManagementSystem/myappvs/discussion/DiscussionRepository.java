package com.CourseManagementSystem.myappvs.discussion;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DiscussionRepository extends MongoRepository<Discussion, String> {

    List<Discussion> findByCourseId(Long id);

    Optional<Discussion> findByEmailId(String emailId);

    void deleteByEmailId(String emailId);
}
