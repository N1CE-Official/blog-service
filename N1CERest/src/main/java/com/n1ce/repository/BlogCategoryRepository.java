package com.n1ce.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.n1ce.model.BlogCategory;

public interface BlogCategoryRepository extends MongoRepository<BlogCategory, String> {
	
	@SuppressWarnings("unchecked")
	BlogCategory save(BlogCategory BlogCategory);   
	
	BlogCategory findBlogCategoryById(String id);
	
    List<BlogCategory> findAll();
	
	void deleteById(String id);

	
}