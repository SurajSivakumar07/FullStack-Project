package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductModel;
import com.example.demo.reposistory.ProductReposistory;
@Service
public class ProductService {
	@Autowired 
	ProductReposistory repo;
	
	public String addData(ProductModel prod) {
		repo.save(prod);
		return "Added";
	}
	
	public List<ProductModel> getData(){
		return repo.findAll();
	}

	public Optional<ProductModel> getById(int id) {
	 
		return repo.findById(id);
	}

	public String delete(int id) {
		  repo.deleteById(id);
		  return "deleted";
	}
	
	public String updated(ProductModel prod) {
		repo.save(prod);
		return "Updated";
	}

	public List<ProductModel> sort(String field) {
		return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<ProductModel> pagination(int offset,int pageSize){
		Page <ProductModel> page=repo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<ProductModel> paginationsorted(int offset, int pageSize, String field) {
		Page <ProductModel> page=repo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}
}
