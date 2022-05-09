package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.Billing;

@Repository
public interface BillingOrder extends JpaRepository<Billing, Integer> {

}
