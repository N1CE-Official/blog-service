package com.n1ce.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.n1ce.model.N1cePageble;
import com.n1ce.model.Post;
import com.n1ce.repository.PostRepository;

@Service
@Transactional
public class PostManager {
	
	@Autowired
	private PostRepository postRepository;

	private static final Logger logger = LoggerFactory.getLogger(PostManager.class);    

	public void post(Post post) {
		logger.debug("Start - post");

		try {
			postRepository.save(post);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - post");
		}
	}


	public Post getPost(String id) {
		logger.debug("Start - getPost - id: {}", id);
		Post post;

		try {
			post = postRepository.findPostById(id);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - getPost");
		}

		return post;
	}
	
	public boolean deletePost(String id) throws Exception {
        logger.debug("Start - deletePost");
        boolean result = false;

        try {
        	postRepository.deleteById(id);
        	result = true;
        	
        } catch (Exception e) {
            logger.error("The error is: ", e);
            throw e;
        } finally {
            logger.debug("End - deletePost");
        }

        return result;
    }
	
	
	public List<Post> postList() {
		logger.debug("Start - postList");
		List<Post> list;

		try {
			list = postRepository.findAll();       
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - postList");
		}
		return list;
	}


	public List<Post> getPostByCategory(String category) {
		logger.debug("Start - getPostByCategory");
		List<Post> list;

		try {
			list = postRepository.findPostByCategory(category);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - getPostByCategory");
		}
		return list;
	}
	
	
	public List<Post> getPostPaged(N1cePageble filter){
		logger.debug("Start - getPostPaged");
		List<Post> list;
		try {
			list = postRepository.findLimit(PageRequest.of(filter.getPage(), filter.getOffset(), Sort.by(Sort.Direction.DESC, filter.getField())));
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - getPostPaged");
		}
		return list;
	}
	
	

}
