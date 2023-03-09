package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShoesModel {
	@Id
	private int id;
	private String img;
	private String brand;
	private String description;
	private int price;
	private int rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public ShoesModel() {
		super();
	}
	@Override
	public String toString() {
		return "ShoesModel [id=" + id + ", img=" + img + ", brand=" + brand + ", description=" + description
				+ ", price=" + price + ", rating=" + rating + "]";
	}
	 
	
}
