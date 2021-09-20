package com.n1ce.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.n1ce.model.BlogCategory;
import com.n1ce.repository.BlogCategoryRepository;

@Service
@Transactional
public class BlogCategoryManager {
	
	@Autowired
	private BlogCategoryRepository bcRepository;

	private static final Logger logger = LoggerFactory.getLogger(BlogCategoryManager.class);    

	public void save(BlogCategory bc) {
		logger.debug("Start - save - BlogCategoryManager");

		try {
			bcRepository.save(bc);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - save - BlogCategoryManager");
		}
	}


	public BlogCategory getBlogCategory(String id) {
		logger.debug("Start - getBlogCategory - id: {}", id);
		BlogCategory bc;

		try {
			bc = bcRepository.findBlogCategoryById(id);
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - getBlogCategory");
		}

		return bc;
	}
	
	public boolean deleteBlogCategory(String id) throws Exception {
        logger.debug("Start - deleteBlogCategory");
        boolean result = false;

        try {
        	bcRepository.deleteById(id);
        	result = true;
        	
        } catch (Exception e) {
            logger.error("The error is: ", e);
            throw e;
        } finally {
            logger.debug("End - deleteBlogCategory");
        }

        return result;
    }
	
	
	public List<BlogCategory> list() {
		logger.debug("Start - list - BlogCategoryManager");
		List<BlogCategory> list;

		try {
			list = bcRepository.findAll();       
		} catch (Exception e) {
			logger.error("The error is: ", e);
			throw e;
		} finally {
			logger.debug("End - list - BlogCategoryManager");
		}
		return list;
	}
	
	

}
