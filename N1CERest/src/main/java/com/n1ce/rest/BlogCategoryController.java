package com.n1ce.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n1ce.manager.BlogCategoryManager;
import com.n1ce.model.BlogCategory;
import com.n1ce.utils.Constants;
import com.n1ce.utils.RestURIConstants;
import com.n1ce.utils.Utility;

@RestController
public class BlogCategoryController {
	
    private static final Logger logger = LoggerFactory.getLogger(BlogCategoryController.class);

    @Autowired
    private BlogCategoryManager manager;    
    
    @RequestMapping(value = RestURIConstants.POST_BC, method = RequestMethod.POST)
    public ResponseEntity<String> blogCategorySave(@RequestBody BlogCategory post) {
       logger.debug("Start - blogCategorySave");
       
       try {
       	
	       	logger.info("post");
	       	Utility.checkParameters(new Object[]{post.getTitle(), post.getArticlesPerRow()});
	       	manager.save(post);
	       
       } catch (Exception e) {
           logger.error("The error is: ", e);
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       } finally {
           logger.debug("End - blogCategorySave");
       }
       return new ResponseEntity<>(Constants.RESULT_OK, HttpStatus.OK);
   }
    
    @RequestMapping(value = RestURIConstants.PUT_BC, method = RequestMethod.PUT)
    public ResponseEntity<String> updateBlogCategory(@RequestBody BlogCategory post) {
       logger.debug("Start - updateBlogCategory");
       
       try {
       	
	       	logger.info("putBlogCategory");
	       	Utility.checkParameters(new Object[]{post.getId(), post.getTitle(), post.getArticlesPerRow()});
	       	manager.save(post);
	       
       } catch (Exception e) {
           logger.error("The error is: ", e);
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       } finally {
           logger.debug("End - updateBlogCategory");
       }
       return new ResponseEntity<>(Constants.RESULT_OK, HttpStatus.OK);
   }

    
    @RequestMapping(value = RestURIConstants.GET_BC_BY_ID, method = RequestMethod.GET)
    public ResponseEntity<BlogCategory> getBlogCategory(@PathVariable("id") String id) {
        logger.debug("Start - getBlogCategory");
        BlogCategory post;

        try {
            Utility.checkParameters(new Object[]{id});
            logger.info("getBlogCategory - id {} ", id);
            post = manager.getBlogCategory(id);
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - getBlogCategory");
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(value = RestURIConstants.DELETE_BC_BY_ID, method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBlogCategory(@PathVariable("id") String id) {
        logger.debug("Start - deleteBlogCategory");
        boolean esito;
        String result = Constants.RESULT_KO;

        try {
            Utility.checkParameters(new Object[]{id});
            logger.info("deleteBlogCategory - id {} ", id);
            esito = manager.deleteBlogCategory(id);
            if(esito)result = Constants.RESULT_OK;
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - deleteBlogCategory");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
  
    @RequestMapping(value = RestURIConstants.GET_BC_LIST, method = RequestMethod.GET)
    public ResponseEntity<List<BlogCategory>> list() {
        logger.debug("Start - list - BlogCategoryController");
        List<BlogCategory> list;

        try {
            logger.info("bcList");
            list = manager.list();
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - list - BlogCategoryController");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
