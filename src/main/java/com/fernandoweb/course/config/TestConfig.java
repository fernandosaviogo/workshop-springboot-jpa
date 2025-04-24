package com.fernandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandoweb.course.entities.User;
import com.fernandoweb.course.repositories.UserRepository;

@Configuration   // Faz a classe ser reconhecida como configuração pelo Spring
@Profile("test")  // configura para rodar essa classe somente o perfil de test (esta configurado no arquivo application-test.properties)
public class TestConfig implements CommandLineRunner{
	
	@Autowired  // Faz a associação abaixo 
	private UserRepository userRepository;  // Objeto que acessa os dados

	@Override
	public void run(String... args) throws Exception {   // Será executado no inicio do programa
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // salva os dados no banco
	}
		
}
