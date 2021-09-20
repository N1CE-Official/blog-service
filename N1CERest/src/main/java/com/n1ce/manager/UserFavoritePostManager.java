package com.n1ce.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.n1ce.model.UserFavoritePost;
import com.n1ce.repository.UserFavoritePostRepository;

@Service
@Transactional
public class UserFavoritePostManager {
	
	@Autowired
	private UserFavoritePostRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(UserFavoritePostManager.class);    

	public void save(UserFavoritePost post) {
		logger.debug("Start - UserFavoritePost (save)");

		try {
			repository.save(post);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - blogCategorySave");
		}
	}


	public UserFavoritePost getUserFavoritePost(String id) {
		logger.debug("Start - getUserFavoritePost - id: {}", id);
		UserFavoritePost post;

		try {
			post = repository.findUserFavoritePostById(id);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - getUserFavoritePost");
		}

		return post;
	}
	
	public boolean deleteUserFavoritePost(String id) throws Exception {
        logger.debug("Start - deleteUserFavoritePost");
        boolean result = false;

        try {
        	repository.deleteById(id);
        	result = true;
        	
        } catch (Exception e) {
            logger.error("The error is: ", e);
            throw e;
        } finally {
            logger.debug("End - deleteUserFavoritePost");
        }

        return result;
    }
	
	
	public List<UserFavoritePost> list() {
		logger.debug("Start - list");
		List<UserFavoritePost> list;

		try {
			list = repository.findAll();       
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - list");
		}
		return list;
	}
	
	public List<UserFavoritePost> findUserFavoritePostsByUserId(String userId) {
		logger.debug("Start - findUserFavoritePostsByUserId");
		List<UserFavoritePost> list;

		try {
			list = repository.findUserFavoritePostsByUserId(userId) ;
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - findUserFavoritePostsByUserId");
		}
		return list;
	}



	
	

}
