package com.food.foodSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodSpringApp.dto.Iteam;

public interface ItemRepo extends JpaRepository<Iteam, Integer> {

}
