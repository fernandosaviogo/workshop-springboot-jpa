package com.fernandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// End Point para inserir um usuário no banco de dados
	@PostMapping
	public ResponseEntity<User> isert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();  // Passa a msn 201 quando a chamada deu certo no Postman
		return ResponseEntity.created(uri).body(obj);
	}
	
	// End Ponit para deletar um usuário do banco de dados
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// End Point para atualização de um usuário
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {  // @RequestBody esta recebendo os dados para atualizar
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
