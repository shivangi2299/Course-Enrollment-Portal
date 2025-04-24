package com.CourseManagementSystem.myappvs.discussion;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DiscussionTests {

    @Mock
    private DiscussionRepository discussionRepository;

    @InjectMocks
    private DiscussionService discussionService;

    @Test
    public void testGetDiscussion() {
        // Given
        Long courseId = 1L;
        List<Discussion> discussions = new ArrayList<>();

        when(discussionRepository.findByCourseId(courseId)).thenReturn(discussions);

        // When
        List<Discussion> result = discussionService.getDiscussion(courseId);

        // Then
        assertNotNull(result);
        assertEquals(discussions, result);
    }

    @Test
    public void testSaveDiscussion() {
        // Given
        Discussion discussion = new Discussion();
        discussion.setId("1");
        discussion.setTopicHeading("Test Discussion");
        discussion.setCourseId(1L);
        discussion.setEmailId("test@example.com");

        when(discussionRepository.save(any(Discussion.class))).thenReturn(discussion);

        // When
        Discussion savedDiscussion = discussionService.saveDiscussion(discussion);

        // Then
        assertNotNull(savedDiscussion);
        assertEquals(discussion.getId(), savedDiscussion.getId());
        assertEquals(discussion.getTopicHeading(), savedDiscussion.getTopicHeading());
        assertEquals(discussion.getCourseId(), savedDiscussion.getCourseId());
        assertEquals(discussion.getEmailId(), savedDiscussion.getEmailId());
    }

    @Test
    public void testDeleteDiscussionById() {
        // Given
        String id = "1";
        String emailId = "test@example.com";
        Discussion discussion = new Discussion();
        discussion.setId(id);
        discussion.setEmailId(emailId);

        when(discussionRepository.findById(id)).thenReturn(Optional.of(discussion));
        doNothing().when(discussionRepository).deleteById(id);

        // When
        discussionService.deleteDiscussionById(id, emailId);

        // Then
        verify(discussionRepository, times(1)).deleteById(id);
    }
    @Test
    public void testUpdateDiscussion() {
        // Given
        String id = "1";
        String emailId = "test@example.com";
        Discussion existingDiscussion = new Discussion();
        existingDiscussion.setId("1");
        existingDiscussion.setEmailId(emailId);
        Discussion updatedDiscussion = new Discussion();
        updatedDiscussion.setTopicHeading("Updated Discussion");

        when(discussionRepository.findById(id)).thenReturn(Optional.of(existingDiscussion));
        when(discussionRepository.save(any(Discussion.class))).thenReturn(updatedDiscussion);

        // When
        Discussion result = discussionService.updateDiscussion(id, emailId, updatedDiscussion);

        // Then
        assertNotNull(result);
        assertEquals(updatedDiscussion.getTopicHeading(), result.getTopicHeading());
    }

}
