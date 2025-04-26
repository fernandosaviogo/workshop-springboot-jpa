package com.fernandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoweb.course.entities.User;
import com.fernandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired  // Faz a injeção de dependência
	private UserService service;
	
	// End Point para buscar uma lista de usuários
	@GetMapping   // Metodo que responde uma requisição do tipo Get 
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	// End Point para buscar um usuário por id na URL
	@GetMapping(value = "/{id}") // Requisição vai aceitar um id dentro da URL para retornar um usuário
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
