package com.n1ce.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.n1ce.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	@SuppressWarnings("unchecked")
	Post save(Post post);   
	
	Post findPostById(String id);
	
    List<Post> findAll();
	
	void deleteById(String id);

	List<Post> findPostByCategory(String category);
	
}