package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    @Override
    List<Product> findAll();

}