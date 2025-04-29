package com.fernandoweb.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.fernandoweb.course.entities.Order;
import com.fernandoweb.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable  // declara que uma classe será incorporada por outras entidades
public class OrderItemPk implements Serializable {
	private static final long serialVersionUID = 1L;

	// Variaveis
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	// Metodos Gets e Sets
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	// Metodo hashCode
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
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
		OrderItemPk other = (OrderItemPk) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

}
