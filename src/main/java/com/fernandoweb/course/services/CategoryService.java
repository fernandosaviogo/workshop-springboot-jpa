package com.fernandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandoweb.course.entities.Category;
import com.fernandoweb.course.repositories.CategoryRepository;

@Service // Registra um serviço na camada de serviço
public class CategoryService {
	
	@Autowired  // Faz a injeção de dependência
	private CategoryRepository repository;
	
	public List<Category> findAll() {  // Faz o repasse da chamada para o repository.findAll()
		return repository.findAll();	
	}
	
	public Category findById(Long id) {  // Retorna um categoria pelo ID
		
		Optional<Category> obj =  repository.findById(id);
		return obj.get();
		
	}

}
