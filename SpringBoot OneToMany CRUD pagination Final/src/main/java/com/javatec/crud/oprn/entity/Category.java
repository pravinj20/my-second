package com.javatec.crud.oprn.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")

public class Category {

	//make id as a primary key
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;

	//one To many relationship mapping
	@OneToMany(cascade =CascadeType.ALL)
    //"ALL" is apply for product bcz product is child entity of category
	// One Category mapping to Many Product
	//now @joinColumn anotation define a foreign key
	@JoinColumn(name = "Category_Product_Fk", referencedColumnName = "id")
	List<Product> product=new ArrayList<>();	
	
	
	public Category() {
		
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	

}
