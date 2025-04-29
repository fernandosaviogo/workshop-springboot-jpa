package com.fernandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandoweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
