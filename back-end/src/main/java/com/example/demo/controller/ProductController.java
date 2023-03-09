package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;
 
import com.example.demo.service.ProductService;
 

@RestController
public class ProductController {
	
	
	@Autowired
	ProductService prod;
	
	
	
	@PostMapping("/products")
	public String add(@RequestBody ProductModel proModel) {
		return prod.addData(proModel);
	}
	
	@GetMapping("/products")
	public List<ProductModel> get(){
		return prod.getData();
	}
	
	@PutMapping("/products")
	public String updates(@RequestBody ProductModel prodModel) {
		return prod.updated(prodModel);
	}
 
	@DeleteMapping("/products")
	public String delte(@RequestParam int id) {
	
		return prod.delete(id);
	}
	
	@GetMapping("/products/{field}")
	public List<ProductModel> readSorted(@PathVariable String field){
		return prod.sort(field);
	}
	
	@GetMapping("/products/{offset}/{pageSize}")
	public List<ProductModel> readPaginated(@PathVariable int offset,@PathVariable int pageSize){
		return prod.pagination(offset,pageSize);
	}
	
	@GetMapping("/products/{offset}/{pageSize}/{field}")
	public List<ProductModel> readPaginatedSorted(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		return prod.paginationsorted(offset,pageSize,field);
	}
	
}
