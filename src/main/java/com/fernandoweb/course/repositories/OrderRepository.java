package com.fernandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
