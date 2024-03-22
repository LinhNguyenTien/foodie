package com.kt.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.backend.entity.Account;
import com.kt.backend.entity.Order;
import com.kt.backend.entity.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByOrderStatus(OrderStatus orderStatus);
	
	List<Order> findByAccount(Account account);
	
}
