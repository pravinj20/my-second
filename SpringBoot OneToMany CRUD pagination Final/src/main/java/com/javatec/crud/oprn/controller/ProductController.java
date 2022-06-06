package com.javatec.crud.oprn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatec.crud.oprn.dto.APIResponse;
import com.javatec.crud.oprn.entity.Product;
import com.javatec.crud.oprn.service.ProductService;

//http methods will be writte here
@RestController
//will talk to service class
public class ProductController {

	//then we need to inject services in controller class
	@Autowired
	private ProductService service;
	//1.Post method //create a new product
		@PostMapping("api/product")
         public Product addProduct(@RequestBody Product product) {
			//@RequestBody<== input json can be pass to "Product" object
			return service.saveProduct(product);
		}
		@PostMapping("api/products")
		 public List<Product> addProducts(@RequestBody List<Product> products) {
				//@RequestBody<== input json can be pass to "Product" object
				return service.saveProducts(products);
			}
		//2.Get method //get product
		@GetMapping("api/products1?page=2")
		public List<Product> findAllProduct(){
			return service.getProducts();
		}
		@GetMapping("api/products2/{id}")
		public Product findProductById(@PathVariable long id) {
			return service.getProductById(id);
		}
		@GetMapping("api/products3/{name}")
		public Product findProductByName(String name) {
			return service.getProductByName(name);
		}
		
	
		//3.Put = Update product
		@PutMapping("api/products4/{id}")
		public Product updateProduct(@RequestBody Product product) {
			return service.updateProduct(product);
		}
		//4. Delete
		@DeleteMapping("api/products5/{id}")
		public String deleteProduct(@PathVariable long id) {
			return service.deleteProduct(id);
		}
		
		//pagination Api
		@GetMapping("api/productsp")
		private APIResponse<List<Product>> getProduct(){
			List<Product> allProducts = service.findAllProducts();
			return new APIResponse<>(allProducts.size(),allProducts);
		}
		
		//pagination of no. of elements in a page = page size   and page ano.
		@GetMapping("api/products/{offset}/{pageSize}")
		private APIResponse<Page<Product>> getProductWithSort(@PathVariable int offset, @PathVariable int pageSize){
			Page<Product> productsWithPagination = service.findProductwithPagination(offset, pageSize);
			return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
			
		}
    

}
