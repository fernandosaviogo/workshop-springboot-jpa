package com.fernandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")  // Expecifica o nome da tabela como tb_user para efitar conflito com a palavra user restrita
public class User implements Serializable{   // O Serializable faz o objeto ser uma cadeia de bits para trafegar em rede ou gravar.
	
	// Numero de serie para implementação do Serializable
	private static final long serialVersionUID = 1L;
	
	// Variaveis 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	// Faz a implantação de varias ordens para um usuário (forma de lista)
	@JsonIgnore  // Faz com que o programa não fique em loop quando um cliente chamar um pedido
	@OneToMany(mappedBy = "client")  // Transforma em chave extrangeira de 01 para muitos no banco
	private List<Order> orders = new ArrayList<>();
	
	
	// Constrautor vazio
	public User() {
		
	}
	
	// Metodo construtor
	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	// Metodos Gets e Sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// Get Order correspondente a lista de orders acima na classe
	public List<Order> getOrders() {
		return orders;
	}
	
	// Metodo hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	// Metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
}
