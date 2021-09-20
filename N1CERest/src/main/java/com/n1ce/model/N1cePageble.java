package com.n1ce.model;

import java.io.Serializable;

public class N1cePageble implements Serializable{

	
	private static final long serialVersionUID = 9201354767401792334L;
	
	private Integer page;
	private Integer offset;
	private String field;
	// TODO ASC DESC
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	
}
