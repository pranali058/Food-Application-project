package com.food.foodSpringApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodSpringApp.dto.FoodOrder;
import com.food.foodSpringApp.dto.Iteam;
import com.food.foodSpringApp.repository.FoodOrderRepo;
import com.food.foodSpringApp.repository.ItemRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepo foodOrderRepo; 
	@Autowired
	ItemRepo itemRepo;
	
	public  FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		List<Iteam>listOfIteams=foodOrder.getIteams();
		List<Iteam>res=new ArrayList<>();
		if (listOfIteams.isEmpty()) {
			foodOrder=foodOrderRepo.save(foodOrder);
		} else {
           foodOrder=foodOrderRepo.save(foodOrder);
		for(Iteam iteam:listOfIteams)
		{
			iteam.setFoodOrder(foodOrder);
		    res.add(itemRepo.save(iteam));
		}
		foodOrder.setIteams(res);
	}
	return foodOrder;
}
	public Optional<FoodOrder> getFoodOrder(int id) {
		return foodOrderRepo.findById(id);
	}
	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderRepo.findAll();
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}
	public void deleteFoodOrder(int id) {
		foodOrderRepo.deleteById(id);
	}
}