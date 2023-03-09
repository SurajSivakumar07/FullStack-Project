package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
 

@Entity
public class ProductModel {
	
	@Id
	@JsonIgnore
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductModel() {
		super();
	}

	@Override
	public String toString() {
		return "productModel [id=" + id + ", name=" + name + "]";
	}
	


 
 

	 

	
	
	
	

}
