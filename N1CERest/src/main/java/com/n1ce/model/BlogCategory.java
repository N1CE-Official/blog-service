package com.n1ce.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "blogCategory")
public class BlogCategory {
	
	
	
	@Id
	private String id;
	
	@Field("title")
	private String title;
	  
	@Field("articlesPerRow")
	private BigInteger articlesPerRow;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigInteger getArticlesPerRow() {
		return articlesPerRow;
	}

	public void setArticlesPerRow(BigInteger articlesPerRow) {
		this.articlesPerRow = articlesPerRow;
	}
	
	@Override
	public String toString() {
		return "BlogCategory [id=" + id + ", title=" + title + ", articlesPerRow=" + articlesPerRow + "]";
	}


}
