package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.controller.global.GlobalData;
import com.demo.controller.services.CategoryService;
import com.demo.controller.services.ProductService;

@Controller
public class HomeCon {
	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	ProductService  productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());

		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model) {
		 
		model.addAttribute("category", categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProdcut());
		model.addAttribute("cartCount", GlobalData.cart.size());

		

		return "shop";
	}
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		 
		model.addAttribute("category", categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProductsByCategory(id));
		model.addAttribute("cartCount", GlobalData.cart.size());

		

		return "shop";
	}
	@GetMapping("/shop/viewproduct/{id}")
	public String shopByViewProduct(Model model, @PathVariable int id) {
		 
		model.addAttribute("products", productService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());

		

		return "viewProduct";
	}
	
	
	

}
