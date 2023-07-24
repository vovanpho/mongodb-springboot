package com.example.mongodbspringboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document()
public class GroseryItem{
    @Id
    private String id;
    private String name;
    private int quatity;
    private String category;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public GroseryItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroseryItem(String id, String name, int quatity, String category) {
		super();
		this.id = id;
		this.name = name;
		this.quatity = quatity;
		this.category = category;
	}
    
    
}