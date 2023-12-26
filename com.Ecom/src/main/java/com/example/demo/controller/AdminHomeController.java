package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.Category;
import com.example.demo.controller.services.CategoryService;
@RestController
public class AdminHomeController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin")
	public String adminsHome(){
		return "AdminHomeController";
	}
	@GetMapping("/admin/categories")
	public String getCat(Model model) {
		model.addAttribute("category", categoryService.getAllCategory());
		return "categories";
				}
	
	
	
	@GetMapping("/admin/categories/add")
	public String addCatadd(Model model) {
		model.addAttribute("category",new Category());
		return "categoriesAdd";
				}
	
	
	
	@PostMapping("/admin/categories/add")
	public String postCatadd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
				}
	
	
	
	
	@GetMapping("/admin/products")
	public String getproducts() {
		return "products";
				}
	@GetMapping("/admin/products/add")
	public String addproducts() {
		return "productsAdd";
				}
	
	


}
