package run.com.Service;

mport java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.com.daos.CategoryRepository;
import run.com.model.Category;


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