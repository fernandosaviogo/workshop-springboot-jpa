package com.fernandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fernandoweb.course.entities.User;
import com.fernandoweb.course.repositories.UserRepository;
import com.fernandoweb.course.services.exceptions.DatabaseException;
import com.fernandoweb.course.services.exceptions.ResourceNotFoundException;

@Service // Registra um serviço na camada de serviço
public class UserService {
	
	@Autowired  // Faz a injeção de dependência
	private UserRepository repository;
	
	public List<User> findAll() {  // Faz o repasse da chamada para o repository.findAll()
		return repository.findAll();	
	}
	
	public User findById(Long id) {  // Retorna um usuário pelo ID
		Optional<User> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));   //orElseThrow faz a tentativa de GET se não encontrar dados lança a exceção descrita nos parenteses
	}
	
	public User insert(User obj) {   // Insere no banco de dados de um novo objeto do tipo User
		return repository.save(obj);
	}
	
	// Deleta um usuário do banco de dados
	public void delete(Long id) {  
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Faz um update não dados do usuário (AS duas classes abaixo)
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);   // Vai monitorar o objeto no JPA e depois que vai ser trabalhado no banco de dados
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {  // Não atualiza todos os campos do usuário
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
