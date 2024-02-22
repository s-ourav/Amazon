package com.example.Amazon.Repos;

import com.example.Amazon.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {
}
