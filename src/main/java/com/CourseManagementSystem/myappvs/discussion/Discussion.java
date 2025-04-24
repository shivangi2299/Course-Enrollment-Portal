package com.CourseManagementSystem.myappvs.discussion;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;





@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "discussion")
public class Discussion {
    @Id
    private String id;
    private LocalDate date;
    private String topicHeading;

    private Long courseId;
    private String emailId;
    private String description;



}
