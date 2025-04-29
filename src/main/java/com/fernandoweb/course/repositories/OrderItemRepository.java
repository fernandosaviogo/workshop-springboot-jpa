package com.fernandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandoweb.course.entities.OrderItem;
import com.fernandoweb.course.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{   // troquei o Long pelo OrderItemPk porque e uma chave composta

}
