package com.example.demo.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.model.Category;
import com.example.demo.controller.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	 CategoryRepository categoryRepository;
	
	 public List<Category>getAllCategory(){
		 return categoryRepository.findAll();
	 }

	public void addCategory(Category category) {
		  categoryRepository.save(category);
	}
	
	
	

}
