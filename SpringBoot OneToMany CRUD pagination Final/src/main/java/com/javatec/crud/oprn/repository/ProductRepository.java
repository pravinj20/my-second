package com.javatec.crud.oprn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatec.crud.oprn.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);

	

}
