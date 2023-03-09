package com.example.demo.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ClothingModel;

public interface ClothingReposistory  extends JpaRepository<ClothingModel, Integer>{

}
