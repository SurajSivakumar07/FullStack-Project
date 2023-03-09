package com.example.demo.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ElectronicsModel;

public interface ElectronicsReposistory extends JpaRepository<ElectronicsModel, Integer> {

}
