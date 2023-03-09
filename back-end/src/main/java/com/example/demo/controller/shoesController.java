package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 
import com.example.demo.model.ShoesModel;
import com.example.demo.service.ShoesService;

import jakarta.persistence.Table;

@RestController
@Table(name="Shoes")
public class shoesController {
	
	@Autowired
	ShoesService shoes;
	@CrossOrigin
	@PostMapping("/shoes")
	public String add(@RequestBody ShoesModel shoe) {
			shoes.addShoes(shoe);
			return "added";
	}
	@CrossOrigin
	@GetMapping("/shoes")
	public List<ShoesModel> getData() {
		return shoes.getShoes();
	}
	@GetMapping("/shoes/{id}")
	public Optional<ShoesModel> getById(@PathVariable int id){
		return shoes.addById(id);
	}
	
	@PutMapping("/shoes")
	public String update(@RequestBody ShoesModel model) {
			return shoes.update(model);
	}
	
	@GetMapping("/shoes/{field}")
	public List<ShoesModel> sortoff(@PathVariable String field)
	{
		return shoes.sorted(field);
	}
	
	@GetMapping("/shoes/{offset}/{pageSize}")
	public List<ShoesModel> readPaginated(@PathVariable int offset,@PathVariable int pageSize){
		return shoes.pagination(offset,pageSize);
	}
	@GetMapping("/shoes/{offset}/{pageSize}/{field}")
	public List<ShoesModel> Paginationsort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return shoes.paginationSorted(offset,pageSize,field);
	}
	
	@DeleteMapping("/shoes")
	public String delte(@RequestParam int id)
	{
		return shoes.deleted(id);
	}
 
}



