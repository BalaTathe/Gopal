package com.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.controller.dto.ProductDTO;
import com.demo.controller.model.Category;
import com.demo.controller.model.Product;
import com.demo.controller.services.CategoryService;
import com.demo.controller.services.ProductService;

@Controller
public class Index {
//	public static String uploadDir=System.getProperty("user.dir")+"/static/prodcutImages";
	public String uploadDir="src/main/resources/static/productImages";
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@RequestMapping("/")
	public String getHome()
	{
		return "index";
	}
	@GetMapping("/category")
	public String getCat(Model model) {
		model.addAttribute("category", categoryService.getAllCategory());
		return "category";
	}
	
	@GetMapping("/category/add")
	public String getCatAdd(Model model) {
		model.addAttribute("category",new Category());
		return "addCategory";
	}
	
	@PostMapping("/category/add")
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		
		return "redirect:/category";
	}
	@GetMapping("/category/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/category";
		
	}
	@GetMapping("/category/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {
		Optional<Category> category=categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "addCategory";
			
		} else {
			return "404";

		}
	}
	
	
	// Prodcutss section
	
	@GetMapping("/products")
	public String products(Model model) {
		model.addAttribute("products",productService.getAllProdcut());
		return "products";
	}
	
	@GetMapping("/products/add")
	public String addProductsget(Model model) {
		model.addAttribute("productDTO",new ProductDTO());
		model.addAttribute("category",categoryService.getAllCategory());
		return "addProducts";
	}
	
	@PostMapping("/products/add")
	public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,
			                     @RequestParam("productImage") MultipartFile file,
//			                     )
			                     
//			                     @RequestParam("imgName")String imgName,
			                     @RequestParam(value="imgName", required=false)String imgName)
			                     throws IOException
	{
	
		Product product=new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID=file.getOriginalFilename();
			Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}
		else {
			imageUUID=imgName;
		}
		product.setImageName(imageUUID);
		productService.addProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.removeProductById(id);
		return "redirect:/products";
		
	}
	@GetMapping("/product/update/{id}")
    public String updateProduct(@PathVariable long id, Model model) {
		Product product=productService.getProductById(id).get();
		ProductDTO productDTO=new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId((product.getCategory().getId()));
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());
		productDTO.setDescription(product.getDescription());
		productDTO.setImgName(product.getImageName());
		model.addAttribute("category",categoryService.getAllCategory());
		model.addAttribute("productDTO", productDTO);
		
		
			return "addProducts";
			
		} 
	}
	
	
	


