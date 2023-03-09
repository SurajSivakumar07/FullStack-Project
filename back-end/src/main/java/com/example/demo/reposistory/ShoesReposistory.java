package com.example.demo.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ShoesModel;

public interface ShoesReposistory  extends JpaRepository<ShoesModel,Integer>{

}
