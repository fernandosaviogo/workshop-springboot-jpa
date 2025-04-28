package com.fernandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
