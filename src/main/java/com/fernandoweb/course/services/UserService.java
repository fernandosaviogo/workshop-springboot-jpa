package com.fernandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandoweb.course.entities.User;
import com.fernandoweb.course.repositories.UserRepository;

@Service // Registra um serviço na camada de serviço
public class UserService {
	
	@Autowired  // Faz a injeção de dependência
	private UserRepository repository;
	
	public List<User> findAll() {  // Faz o repasse da chamada para o repository.findAll()
		return repository.findAll();	
	}
	
	public User findById(Long id) {  // Retorna um usuário pelo ID
		
		Optional<User> obj =  repository.findById(id);
		return obj.get();
		
	}

}
