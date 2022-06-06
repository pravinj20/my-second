package com.javatec.crud.oprn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatec.crud.oprn.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
