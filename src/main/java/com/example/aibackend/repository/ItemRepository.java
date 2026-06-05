package com.example.aibackend.repository;

import com.example.aibackend.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNameContaining(String keyword);
}
