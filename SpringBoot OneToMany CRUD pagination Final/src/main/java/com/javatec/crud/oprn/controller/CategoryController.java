package com.javatec.crud.oprn.controller;

import java.util.List;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatec.crud.oprn.entity.Category;
import com.javatec.crud.oprn.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	//get all Categories
	@GetMapping
	public List<Category> getAllCategory(){
		return this.categoryRepository.findAll();
	}
	//get category by id
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable (value="id") long categoryId) {
		return this.getCategoryById(categoryId);
	}
	// create Category
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return this.categoryRepository.save(category);
	}
	//Update Category
	@PutMapping("/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable("id") long categoryId) throws RoleInfoNotFoundException {
		Category existingCategory = this.categoryRepository.findById(categoryId).orElseThrow(() -> new RoleInfoNotFoundException("Category not found with id :"+ categoryId));
		existingCategory.setName(category.getName());
		return this.categoryRepository.save(existingCategory);
	}
	//Delete Category by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable ("id") long categoryId){
		Category existingCategory = null;
		try {
			existingCategory = this.categoryRepository.findById(categoryId)
					.orElseThrow(() -> new RoleInfoNotFoundException("Category not found with id :"+ categoryId));
		} catch (RoleInfoNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.categoryRepository.delete(existingCategory);
		return ResponseEntity.ok().build();
	}
}
