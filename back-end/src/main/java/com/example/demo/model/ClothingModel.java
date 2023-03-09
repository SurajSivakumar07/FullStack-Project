package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class ClothingModel {

	@Id
	private int id;
	private String type;
	private String gender;
	private String brand;
	private String img;
	private int price;
	private int rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public ClothingModel() {
		super();
	}
	@Override
	public String toString() {
		return "ClothingModel [id=" + id + ", type=" + type + ", gender=" + gender + ", brand=" + brand + ", img=" + img
				+ ", price=" + price + ", rating=" + rating + "]";
	}
	
	
	
}
