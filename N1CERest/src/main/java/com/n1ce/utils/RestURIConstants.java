package com.n1ce.utils;

public class RestURIConstants {

	//POSTS
    public static final String POST_POSTS = "/posts";
    public static final String PUT_POSTS = "/posts";
    public static final String GET_POSTS_LIST = "/posts/list";
    public static final String GET_POSTS_BY_ID = "/posts/{id}";
    //public static final String PUT_POSTS_BY_ID = "/posts/{id}";
    public static final String DELETE_POSTS_BY_ID = "/posts/{id}";
    public static final String GET_POSTS_BY_CATEGORY = "/posts/{category}";
    
    //BLOG CATEGORY
	public static final String POST_BC = "/blog-category";
	public static final String PUT_BC = "/blog-category";
	public static final String GET_BC_BY_ID = "/blog-category/{id}";
	public static final String DELETE_BC_BY_ID = "/blog-category/{id}";
	public static final String GET_BC_LIST = "/blog-category/list";
	
	
	
	public static final String POST_UFP = "/user-favorite-post";
	public static final String PUT_UFP = "/user-favorite-post";;
	public static final String GET_UFP_BY_ID = "/user-favorite-post/{id}";
	public static final String GET_UFP_LIST = "/user-favorite-post/list";
	public static final String DELETE_UFP_BY_ID = "/user-favorite-post/{id}";
    

}
