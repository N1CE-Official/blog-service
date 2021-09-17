package com.n1ce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "posts")
public class Post {
	
  @Id
  private String id;
  
  @Field("userId")
  private String userId;
  
  @Field("title")
  private String title;
  
  @Field("body")
  private String body;
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
	this.id = id;
  }

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	  @Override
	  public String toString() {
	    return "Tutorial [id=" + id + ", userId=" +  userId + ", title=" + title + ", body=" +  body + "]";
	  }
}