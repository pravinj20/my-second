package com.javatec.crud.oprn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.javatec.crud.oprn.entity.Product;
import com.javatec.crud.oprn.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
private ProductRepository repository;

//All http method:
// post = create
//	get =fetch= 
//	put =update
//	delete

// post method: to save the product object to the database
// this method add single product

public Product saveProduct(Product product) {
	return repository.save(product);
}
//this method is for add/save  multiple product object to the database 
public List<Product> saveProducts(List<Product> products) {
	return repository.saveAll(products);
}
//Get method== > to fetch products from the database
	// fetch multiple objects
public List<Product> getProducts(){
	return repository.findAll();
}
// fetch  single object by id
public Product getProductById(long id) {
	return repository.findById(id).orElse(null);
}
//fetch single object by name
public Product getProductByName(String name) {
	return repository.findByName(name); 
}
//Delete
public String deleteProduct(long id) {
	repository.deleteById(id);
	return "Product removed :"+id;
}
//update product
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setId(product.getId());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setName(product.getName());
		return repository.save(existingProduct);
		
	}
	//To load all the product from database
	//Get Method
	public List<Product> findAllProducts(){
		return repository.findAll();
	}
	
	// Pagination logic
	public Page<Product> findProductwithPagination(int offset, int pageSize){
		Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

}
