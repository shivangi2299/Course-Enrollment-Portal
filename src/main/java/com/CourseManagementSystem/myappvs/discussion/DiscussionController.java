package com.CourseManagementSystem.myappvs.discussion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionController {


    private DiscussionService discussionService;



    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    @GetMapping("/showDiscussion/{id}")
    public  List<Discussion> showDiscussion(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // Extract user email from authentication principal
            String emailId = authentication.getName();
            System.out.println("email id the user is "+emailId);
            List<Discussion> currentDiscussion = discussionService.getDiscussion(id);

            return currentDiscussion;


        }
        return null;

    }
    @PostMapping("/create")
    public Discussion createDiscussion(@Validated @RequestBody Discussion discussion) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
//            String emailId = authentication.getName();
//            // Here you can fetch and set the student object based on the
//
//
//            Long courseid = discussion.getCourseId();
//            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            discussion.setEmailId(userDetails.getUsername());
//
//            //discussion.setEmailId(emailId);
//            discussion.setId(Long.valueOf(UUID.randomUUID().toString()));
//            discussion.setDate(LocalDate.now());
            String emailId = authentication.getName();
            // Here you can fetch and set the student object based on the


            Long courseid= discussion.getCourseId();


            discussion.setEmailId(emailId);
            discussion.setDate(LocalDate.now());
            return discussionService.saveDiscussion(discussion);


        }
        return null;
    }

//    @PutMapping("/update/{id}")
//    public Discussion updateDiscussion(@PathVariable String id, @RequestBody Discussion discussionDetails) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            String emailId = authentication.getName();
//            return discussionService.updateDiscussion(id, emailId, discussionDetails);
//        }
//        return null;
//    }
@PutMapping("/update/{id}")
public ResponseEntity<?> updateDiscussion(@PathVariable String id, @Validated @RequestBody Discussion discussionDetails) {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String authenticatedUserEmail = userDetails.getUsername();

    Discussion discussion = discussionService.getDiscussionById(id)
            .orElseThrow(() -> new IllegalArgumentException("Discussion not found"));

    // Check if the authenticated user is the owner of the discussion
    if (!discussion.getEmailId().equals(authenticatedUserEmail)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("You are not authorized to update this discussion. This discussion is not posted by you.");
    }

    discussion.setTopicHeading(discussionDetails.getTopicHeading());
    discussion.setDescription(discussionDetails.getDescription());

    final Discussion updatedDiscussion = discussionService.saveDiscussion(discussion);
    return ResponseEntity.ok(updatedDiscussion);
}

    //    @DeleteMapping("/delete/{id}")
//    public void deleteDiscussion(@PathVariable String id) {
//        discussionService.deleteDiscussionById(String.valueOf(id));
//    }
    @GetMapping("/getEmail")
    public String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            }
        }
        return null;
    }
        @DeleteMapping("/delete/{id}")
        public void deleteDiscussion(@PathVariable String id) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                String emailId = authentication.getName();
                discussionService.deleteDiscussionById(id, emailId);
            }
        }

}
