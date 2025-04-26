package com.fernandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandoweb.course.entities.Order;
import com.fernandoweb.course.repositories.OrderRepository;

@Service // Registra um serviço na camada de serviço
public class OrderService {
	
	@Autowired  // Faz a injeção de dependência
	private OrderRepository repository;
	
	public List<Order> findAll() {  // Faz o repasse da chamada para o repository.findAll()
		return repository.findAll();	
	}
	
	public Order findById(Long id) {  // Retorna um usuário pelo ID
		
		Optional<Order> obj =  repository.findById(id);
		return obj.get();
		
	}

}
