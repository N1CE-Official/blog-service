package com.n1ce.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "posts")
public class Post {

	@Id
	private String id;

	@Field("expertId")
	private String expertId;

	@Field("title")
	private String title;

	@Field("content")
	private String content;
	
	@Field("snippet")
	private String snippet;

	@Field("featuredImg")
	private String featuredImg;
	
	@Field("category")
	private String category;
	
	@Field("publishingTimeAsString")
	private String publishingTimeAsString;
	
	@Field("publishingTime")
	private Date publishingTime;
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getExpertId() {
		return expertId;
	}
	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public String getFeaturedImg() {
		return featuredImg;
	}
	public void setFeaturedImg(String featuredImg) {
		this.featuredImg = featuredImg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublishingTimeAsString() {
		return publishingTimeAsString;
	}
	public void setPublishingTimeAsString(String publishingTimeAsString) {
		this.publishingTimeAsString = publishingTimeAsString;
	}
	public Date getPublishingTime() {
		return publishingTime;
	}
	public void setPublishingTime(Date publishingTime) {
		this.publishingTime = publishingTime;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", expertId=" + expertId + ", title=" + title + ", content=" + content + ", snippet="
				+ snippet + ", featuredImg=" + featuredImg + ", category=" + category + ", publishingTimeAsString="
				+ publishingTimeAsString + "]";
	}
	
	
	
	

	
}