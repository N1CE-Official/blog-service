package com.n1ce.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.n1ce.model.UserFavoritePost;

public interface UserFavoritePostRepository extends MongoRepository<UserFavoritePost, String> {
	
	@SuppressWarnings("unchecked")
	UserFavoritePost save(UserFavoritePost post);   
	
	UserFavoritePost findUserFavoritePostById(String id);
	
    List<UserFavoritePost> findAll();
	
	void deleteById(String id);
	
	List<UserFavoritePost> findUserFavoritePostsByUserId(String id);

	
}