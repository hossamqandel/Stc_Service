package com.example.stcservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stcservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
