package com.example.Amazon.Repos;

import com.example.Amazon.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustRepo extends JpaRepository<Customer,Integer> {
}
