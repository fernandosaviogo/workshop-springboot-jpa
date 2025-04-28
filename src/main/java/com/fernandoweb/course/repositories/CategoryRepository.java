package com.fernandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandoweb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
