package com.fernandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

// Os @ são referencias do JPA(banco de dados)

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Transient    // Impede que o JPA interprete a linha abaixo
	private Set<Product> products = new HashSet<>();  // A instanciação garante que a products não comece nulo
		
	// Metodo construtor vazio
	public Category() {
		
	}
	
	// Metodo construtor 
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	public Set<Product> getProducts() {
		return products;
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

}
