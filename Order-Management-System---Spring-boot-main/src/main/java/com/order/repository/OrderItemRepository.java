package com.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	@Query("FROM OrderItem WHERE id = ?1")
	List<OrderItem> findAllById(int id);
	
	@Query("FROM OrderItem WHERE id = ?1")
    Optional<OrderItem> findById(Integer id);

		
}
