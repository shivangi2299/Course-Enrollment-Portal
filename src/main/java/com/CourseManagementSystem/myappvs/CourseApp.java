package com.CourseManagementSystem.myappvs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.FilterType;

import com.CourseManagementSystem.myappvs.Notes.StudentNoteRepository;
import com.CourseManagementSystem.myappvs.event.Eventrepo;

@SpringBootApplication(scanBasePackages = {
		"com.CourseManagementSystem.myappvs.event.EventController",
		"com.CourseManagementSystem.myappvs.event.Eventrepository",
		"com.CourseManagementSystem.myappvs.discussion.DiscussionRepository",
		"com.CourseManagementSystem.myappvs.discussion.DiscussionController",
		"com.CourseManagementSystem.myappvs.Notes.StudentNoteController",
		"com.CourseManagementSystem.myappvs.Notes.StudentNoteRepository"})
@EnableMongoRepositories({"com.CourseManagementSystem.myappvs.event",
		"com.CourseManagementSystem.myappvs.discussion", "com.CourseManagementSystem.myappvs.Notes"})
@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
		com.CourseManagementSystem.myappvs.discussion.DiscussionRepository.class,
		com.CourseManagementSystem.myappvs.event.Eventrepo.class,com.CourseManagementSystem.myappvs.Notes.StudentNoteRepository.class }))
//(type = FilterType.ASSIGNABLE_TYPE, value = Eventrepo.class))
@ComponentScan("com.CourseManagementSystem.myappvs")
public class CourseApp {

	public static void main(String[] args) {
		SpringApplication.run(CourseApp.class, args);
		System.out.println("Started...");
	}

}
