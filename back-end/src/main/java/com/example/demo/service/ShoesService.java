package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ShoesModel;
import com.example.demo.reposistory.ShoesReposistory;

@Service
public class ShoesService {

	
	@Autowired
	ShoesReposistory repo;
	
	public String addShoes(ShoesModel shoes) {
		repo.save(shoes);
		return "Added";
	}
	
	public List<ShoesModel> getShoes(){
		return repo.findAll();
	}
	
	public String update(ShoesModel shoes) {
		repo.save(shoes);
		return "updated";
	}

	public Optional<ShoesModel> addById(int id) {
		return repo.findById(id);
	}

	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted";
	}

	public List<ShoesModel> sorted(String field) {
	 
		return  repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<ShoesModel> paginationSorted(int offset, int pageSize, String field) {
		Page <ShoesModel> page=repo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	 
	}

	public List<ShoesModel> pagination(int offset, int pageSize) {
		Page <ShoesModel> page=repo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();

	}

	public String deleted(int id) {
		repo.deleteById(id);
		return "Deleted";
			
	}

 
 
	
	
}
