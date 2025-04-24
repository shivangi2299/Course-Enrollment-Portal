package com.CourseManagementSystem.myappvs.courseCatalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogService {
	
	@Autowired
	private CatalogRepository repo;
	
	public List<Catalog> getAllCourses(){
		System.out.println(repo.count());
		return repo.findAll();
	}

}
