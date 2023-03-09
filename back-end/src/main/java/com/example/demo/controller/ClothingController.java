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
import com.example.demo.model.ClothingModel;
import com.example.demo.service.ClothingSerive;

@RestController

public class ClothingController {
	
	@Autowired
	ClothingSerive clothing;
	
	@PostMapping("/clothing")
	public String add(@RequestBody ClothingModel cloth) {
		return clothing.addData(cloth);
	}
	
	@CrossOrigin
	@GetMapping("/clothing")
	public List<ClothingModel> get(){
		return clothing.getData();
	}
	
	@GetMapping("/clothing/{id}")
	public Optional<ClothingModel> getById(@PathVariable int id){
		return clothing.addById(id);
	}
	@PutMapping("/clothing")
	public String update(@RequestBody ClothingModel cloth) {
		return clothing.upadate(cloth);
	}
	@DeleteMapping("/clothing")
	public String delete(@RequestParam int id) {
		return clothing.delete(id);
	}
	@GetMapping("/clothing/{field}")
	public List<ClothingModel> sorted(@PathVariable String field){
		return clothing.sorted(field);
	}
	
	@GetMapping("/clothing/{offset}/{PageSize}")
	public List<ClothingModel> pagination(@PathVariable int offset,@PathVariable int pageSize){
		return clothing.paginated(offset,pageSize);
	}
	 
	
	@GetMapping("/clothing/{offset}/{PageSize}/{field}")
	public List<ClothingModel> pagination(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		return clothing.paginatedSort(offset,pageSize,field);
	}
}
