package com.fernandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoweb.course.entities.Product;
import com.fernandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired  // Faz a injeção de dependência
	private ProductService service;
	
	// End Point para buscar uma lista de produtos
	@GetMapping   // Metodo que responde uma requisição do tipo Get 
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	// End Point para buscar um produto por id na URL
	@GetMapping(value = "/{id}") // Requisição vai aceitar um id dentro da URL para retornar um usuário
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
