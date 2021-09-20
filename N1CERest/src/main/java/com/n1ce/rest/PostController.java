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

import com.n1ce.manager.PostManager;
import com.n1ce.model.N1cePageble;
import com.n1ce.model.Post;
import com.n1ce.utils.Constants;
import com.n1ce.utils.RestURIConstants;
import com.n1ce.utils.Utility;

@RestController
public class PostController {
	
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostManager postManager;    
    
    @RequestMapping(value = RestURIConstants.POST_POSTS, method = RequestMethod.POST)
    public ResponseEntity<String> postSave(@RequestBody Post post) {
       logger.debug("Start - post");
       
       try {
       	
	       	logger.info("post");
	       	Utility.checkParameters(new Object[]{post.getExpertId(), post.getTitle(), post.getContent()});
	       	postManager.post(post);
	       
       } catch (Exception e) {
           logger.error("The error is: ", e);
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       } finally {
           logger.debug("End - post");
       }
       return new ResponseEntity<>(Constants.RESULT_OK, HttpStatus.OK);
   }
    
    @RequestMapping(value = RestURIConstants.PUT_POSTS, method = RequestMethod.PUT)
    public ResponseEntity<String> postPut(@RequestBody Post post) {
       logger.debug("Start - post");
       
       try {
       	
	       	logger.info("post");
       		Utility.checkParameters(new Object[]{post.getId(), post.getExpertId(), post.getTitle(), post.getContent()});
	       	postManager.post(post);
	       
       } catch (Exception e) {
           logger.error("The error is: ", e);
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       } finally {
           logger.debug("End - post");
       }
       return new ResponseEntity<>(Constants.RESULT_OK, HttpStatus.OK);
   }

    
    @RequestMapping(value = RestURIConstants.GET_POSTS_BY_ID, method = RequestMethod.GET)
    public ResponseEntity<Post> getPost(@PathVariable("id") String id) {

        logger.debug("Start - getPost");
        Post post;

        try {
            Utility.checkParameters(new Object[]{id});
            logger.info("getPost - id {} ", id);
            post = postManager.getPost(id);
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - getPost");
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(value = RestURIConstants.DELETE_POSTS_BY_ID, method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePost(@PathVariable("id") String id) {

        logger.debug("Start - deletePost");
        boolean esito;
        String result = Constants.RESULT_KO;

        try {
            Utility.checkParameters(new Object[]{id});
            logger.info("deletePost - id {} ", id);
            esito = postManager.deletePost(id);
            if(esito)result = Constants.RESULT_OK;
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - deletePost");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
  
    @RequestMapping(value = RestURIConstants.GET_POSTS_LIST, method = RequestMethod.GET)
    public ResponseEntity<List<Post>> postList() {
        logger.debug("Start - postList");
        List<Post> list;

        try {
            logger.info("postList");
            list = postManager.postList();
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - postList");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = RestURIConstants.GET_POSTS_BY_CATEGORY, method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPostByCategory(@PathVariable("category") String category) {

        logger.debug("Start - getPostByCategory");
        List<Post> posts;

        try {
            Utility.checkParameters(new Object[]{category});
            logger.info("getPost - category {} ", category);
            posts = postManager.getPostByCategory(category);
            
        } catch (Exception e) {
            logger.error("The error is: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            logger.debug("End - getPostByCategory");
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    
    @RequestMapping(value = RestURIConstants.POST_POSTS_PAGED, method = RequestMethod.POST)
    public ResponseEntity<List<Post>> getPostPaged(@RequestBody N1cePageble filter) {
       logger.debug("Start - getPostPaged");
       List<Post> posts;
       try {
	       	Utility.checkParameters(new Object[]{filter.getField(), filter.getOffset(), filter.getPage()});
	       	posts=postManager.getPostPaged(filter);
	       
       } catch (Exception e) {
           logger.error("The error is: ", e);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       } finally {
           logger.debug("End - getPostPaged");
       }
       return new ResponseEntity<>(posts, HttpStatus.OK);
   }

}
