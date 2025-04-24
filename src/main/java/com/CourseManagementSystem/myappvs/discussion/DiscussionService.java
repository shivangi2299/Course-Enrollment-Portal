package com.CourseManagementSystem.myappvs.discussion;

import com.CourseManagementSystem.myappvs.student.Student;
import com.CourseManagementSystem.myappvs.student.Studentrepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    private Studentrepository studentrepository;

    public DiscussionService(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    public Student getStudentId(String email) {
        Optional<Student> s = studentrepository.findByEmailId(email);
        return s.orElse(null);
    }

    public List<Discussion> getDiscussion(Long id) {
        return discussionRepository.findByCourseId(id);
    }

    public Discussion saveDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

//    public void deleteDiscussionById(String id) {
//        discussionRepository.deleteById(id);
//    }
        public void deleteDiscussionById(String id, String emailId) {
            Optional<Discussion> optionalDiscussion = discussionRepository.findById(id);
            if (optionalDiscussion.isPresent()) {
                Discussion discussion = optionalDiscussion.get();
                if (discussion.getEmailId().equals(emailId)) {
                    discussionRepository.deleteById(id);
                } else {
                    throw new SecurityException("You are not authorized to delete this discussion.");
                }
            } else {
                throw new EntityNotFoundException("Discussion not found");
            }
        }

//    public Discussion updateDiscussion(String id, String emailId, Discussion discussionDetails) {
//        Optional<Discussion> optionalDiscussion = discussionRepository.findById(id);
//        if (optionalDiscussion.isPresent()) {
//            Discussion discussion = optionalDiscussion.get();
//            // Check if the email matches the creator's email
//            if (discussion.getEmailId().equals(emailId)) {
//                discussion.setTopicHeading(discussionDetails.getTopicHeading());
//                discussion.setDescription(discussionDetails.getDescription());
//                return discussionRepository.save(discussion);
//            } else {
//                throw new SecurityException("You are not authorized to update this discussion.");
//            }
//        } else {
//            throw new EntityNotFoundException("Discussion not found");
//        }
//    }
    public Discussion updateDiscussion(String id, String emailId, Discussion discussionDetails) {
        Optional<Discussion> optionalDiscussion = discussionRepository.findById(id);
        if (optionalDiscussion.isPresent()) {
            Discussion discussion = optionalDiscussion.get();
            if (discussion.getEmailId().equals(emailId)) {
                discussion.setTopicHeading(discussionDetails.getTopicHeading());
                discussion.setDescription(discussionDetails.getDescription());
                return discussionRepository.save(discussion);
            } else {
                throw new SecurityException("You are not authorized to update this discussion.");
            }
        } else {
            throw new EntityNotFoundException("Discussion not found");
        }
    }

    public Optional<Discussion> getDiscussionById(String id) {
        return discussionRepository.findById(id);
    }
}
