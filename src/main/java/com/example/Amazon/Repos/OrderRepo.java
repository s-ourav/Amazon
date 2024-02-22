package com.example.Amazon.Repos;

import com.example.Amazon.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
