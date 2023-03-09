package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ElectronicsModel;
import com.example.demo.reposistory.ElectronicsReposistory;

@Service

public class ElectronicsService {

	
	@Autowired
	
	ElectronicsReposistory repo;
	
	
	public String add(ElectronicsModel model) {
		repo.save(model);
		return "added";
	}
	
	
	public List<ElectronicsModel> get(){
		return repo.findAll();
	}
	
	
	public String update(ElectronicsModel model) {
		repo.save(model);
		return "Updated";
	}

	
	public String delete(int a) {
		repo.deleteById(a);
		return "deleted";
	}

	public Optional<ElectronicsModel> addbyId(int id) {
		return  repo.findById(id);
	}


	public List<ElectronicsModel> sort(String field) {
				return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<ElectronicsModel> paginated(int offset, int pageSize) {
		Page<ElectronicsModel> page=repo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}


	public List<ElectronicsModel> paginatedSort(int offset, int pageSize, String field) {
		// TODO Auto-generated method stub
		
		Page<ElectronicsModel> page=repo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}


 
	
	
}
