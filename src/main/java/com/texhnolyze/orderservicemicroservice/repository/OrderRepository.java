package com.texhnolyze.orderservicemicroservice.repository;

import com.texhnolyze.orderservicemicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
