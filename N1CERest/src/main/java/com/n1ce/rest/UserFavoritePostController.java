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

import com.n1ce.manager.UserFavoritePostManager;
import com.n1ce.model.UserFavoritePost;
import com.n1ce.utils.Constants;
import com.n1ce.utils.RestURIConstants;
import com.n1ce.utils.Utility;

@RestController
public class UserFavoritePostController {

	   private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	    @Autowired
	    private UserFavoritePostManager manager;    
	    
	    @RequestMapping(value = RestURIConstants.POST_UFP, method = RequestMethod.POST)
	    public ResponseEntity<String> save(@RequestBody UserFavoritePost post) {
	       logger.debug("Start - post - UserFavoritePost");
	       
	       try {
		       	Utility.checkParameters(new Object[]{post.getPostId(), post.getUserId()});
		       	manager.save(post);
		       
	       } catch (Exception e) {
	           logger.error("The error is: ", e);
	           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	       } finally {
	           logger.debug("End - post");
	       }
	       return new ResponseEntity<>(Constants.RESULT_OK, HttpStatus.OK);
	   }
	    
	    @RequestMapping(value = RestURIConstants.PUT_UFP, method = RequestMethod.PUT)
	    public ResponseEntity<String> put(@RequestBody UserFavoritePost post) {
	       logger.debug("Start - put - UserFavoritePost ");
	       
	       try {
	       	
		    	Utility.checkParameters(new Object[]{post.getId(),  post.getPostId(), post.getUserId()});
		       	manager.save(post);
		       
	       } catch (Exception e) {
	           logger.error("The error is: ", e);
	           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	       } finally {
	           logger.debug("End - put");
	       }
	       return new ResponseEntity<>(Constants.RESULT_OK, HttpStatus.OK);
	   }

	    
	    @RequestMapping(value = RestURIConstants.GET_UFP_BY_ID, method = RequestMethod.GET)
	    public ResponseEntity<UserFavoritePost> getUfp(@PathVariable("id") String id) {
	        logger.debug("Start - getUfp");
	        UserFavoritePost post;

	        try {
	            Utility.checkParameters(new Object[]{id});
	            logger.info("getUfp - id {} ", id);
	            post = manager.getUserFavoritePost(id);
	            
	        } catch (Exception e) {
	            logger.error("The error is: ", e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        } finally {
	            logger.debug("End - getUfp");
	        }
	        return new ResponseEntity<>(post, HttpStatus.OK);
	    }

	    @RequestMapping(value = RestURIConstants.DELETE_UFP_BY_ID, method = RequestMethod.DELETE)
	    public ResponseEntity<String> deleteUserFavoritePost(@PathVariable("id") String id) {

	        logger.debug("Start - deleteUserFavoritePost");
	        boolean esito;
	        String result = Constants.RESULT_KO;

	        try {
	            Utility.checkParameters(new Object[]{id});
	            logger.info("deleteUserFavoritePost - id {} ", id);
	            esito = manager.deleteUserFavoritePost(id);
	            if(esito)result = Constants.RESULT_OK;
	            
	        } catch (Exception e) {
	            logger.error("The error is: ", e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        } finally {
	            logger.debug("End - deleteUserFavoritePost");
	        }
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	  
	    @RequestMapping(value = RestURIConstants.GET_UFP_LIST, method = RequestMethod.GET)
	    public ResponseEntity<List<UserFavoritePost>> list() {
	        logger.debug("Start - list - UserFavoritePost");
	        List<UserFavoritePost> list;

	        try {
	            logger.info("list");
	            list = manager.list();
	            
	        } catch (Exception e) {
	            logger.error("The error is: ", e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        } finally {
	            logger.debug("End - list");
	        }
	        return new ResponseEntity<>(list, HttpStatus.OK);
	    }
	    
	   
	
}
