package com.fernandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandoweb.course.entities.Product;
import com.fernandoweb.course.repositories.ProductRepository;

@Service // Registra um serviço na camada de serviço
public class ProductService {
	
	@Autowired  // Faz a injeção de dependência
	private ProductRepository repository;
	
	public List<Product> findAll() {  // Faz o repasse da chamada para o repository.findAll()
		return repository.findAll();	
	}
	
	public Product findById(Long id) {  // Retorna um usuário pelo ID
		
		Optional<Product> obj =  repository.findById(id);
		return obj.get();
		
	}

}
