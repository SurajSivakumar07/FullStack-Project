package com.example.demo.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductModel;

public interface ProductReposistory  extends JpaRepository<ProductModel,Integer>{

}
