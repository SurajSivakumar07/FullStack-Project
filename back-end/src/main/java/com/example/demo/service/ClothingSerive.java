package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClothingModel;
import com.example.demo.reposistory.ClothingReposistory;

@Service

public class ClothingSerive {
	
	@Autowired
	ClothingReposistory repo;
	
	
	public String addData(ClothingModel cloths) {
		repo.save(cloths);
		return "added";
	}
	
	public List<ClothingModel> getData(){
			return repo.findAll();
	}
	
	public String upadate(ClothingModel cloths) {
		repo.save(cloths);
		return "updated";
	}

	public String delete(int id) {
		 repo.deleteById(id);
		 return "deleted";
	}
	public Optional<ClothingModel> addById(int id) {
		return repo.findById(id);
	}

	public List<ClothingModel> sorted(String field) {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<ClothingModel> paginated(int offset, int pageSize) {
		// TODO Auto-generated method stub
		Page <ClothingModel> page=repo.findAll(PageRequest.of(offset, pageSize));
		
		return page.getContent();
	}

	public List<ClothingModel> paginatedSort(int offset, int pageSize, String field) {
		 Page <ClothingModel> page=repo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}
 
	
}
