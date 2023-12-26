package com.example.demo.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
//	 Category (int category_id);
//	Category findByCategoryId(int categoryId);
	Category findByCategoryId(int categoryId);



}


