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

import com.example.demo.model.ElectronicsModel;
import com.example.demo.service.ElectronicsService;

import jakarta.persistence.Table;

@RestController
@Table(name="Electronics")

@CrossOrigin(origins="http://localhost:3000/")
public class ElectronicsController {
	
	@Autowired
	ElectronicsService elec;
	
	
	 
	@PostMapping("/electronics")
	public String addData(@RequestBody ElectronicsModel elecs) {
		return  elec.add(elecs);
	}
	
	 
	@GetMapping("/electronics")
	public List<ElectronicsModel> getData(){
		return elec.get();
	}
	
	@GetMapping("/electronics/{id}")
	public Optional<ElectronicsModel> getById(@PathVariable int id) {
		return elec.addbyId(id);
	}
	 
	@PutMapping("/electronics")
	
	public String update(@RequestBody ElectronicsModel elecs ) {
		return elec.update(elecs);
	}
	 
	@DeleteMapping("/electronics/{id}")
	public String delete(@PathVariable int id)
	{
		return elec.delete(id);
	}
	
	
	@GetMapping("/electronics/{field}")
	public List<ElectronicsModel> sortedOff(@PathVariable String field){
			return elec.sort(field);
	}

	
	@GetMapping("/electronics/{offset}/{PageSize}")
	public List<ElectronicsModel> pagination(@PathVariable int offset,@PathVariable int pageSize )
	{
		return elec.paginated(offset,pageSize);
	}
	
	@GetMapping("/electronics/{offset}/{PageSize}/{field}")
	public List<ElectronicsModel> pagination(@PathVariable int offset,@PathVariable int pageSize ,@PathVariable String field )
	{
		return elec.paginatedSort(offset,pageSize,field);
	}
	
	
	
}
