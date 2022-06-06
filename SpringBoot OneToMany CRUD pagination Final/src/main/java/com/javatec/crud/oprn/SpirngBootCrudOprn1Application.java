package com.javatec.crud.oprn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatec.crud.oprn.entity.Category;
import com.javatec.crud.oprn.entity.Product;
import com.javatec.crud.oprn.repository.CategoryRepository;

@SpringBootApplication
public class SpirngBootCrudOprn1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpirngBootCrudOprn1Application.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category category = new Category("One To Many Mapping Using JPA & Hibernate with pagination == > Category");
		Product product1 = new Product("Food", "Chinies");
		Product product2 = new Product("Electronics", "freez");
		Product product3 = new Product("4 wheeler", " foxwagon");
		
		category.getProduct().add(product1);
		category.getProduct().add(product2);
		category.getProduct().add(product3);
		
		this.categoryRepository.save(category);
	}

}
