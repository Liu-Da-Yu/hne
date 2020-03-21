package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InfoDao extends JpaRepository<Info, Integer> {

    @Override
    List<Info> findAll();

}
