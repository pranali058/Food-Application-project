package com.food.foodSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodSpringApp.dao.FoodOrderDao;
import com.food.foodSpringApp.dto.FoodOrder;
import com.food.foodSpringApp.repository.FoodOrderRepo;

@RestController
@RequestMapping("/food")
public class FoodOrderController {

	@Autowired
	FoodOrderDao foodOrderDao;
	
	@PostMapping
	public FoodOrder saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	@GetMapping("/{id}")
	public FoodOrder findFOodById(@PathVariable int id) {
		Optional<FoodOrder>fo=foodOrderDao.getFoodOrder(id);
		if (fo.isPresent()) {
			return fo.get();
		} else {
            return null;
		}
	}
	@GetMapping
	public List<FoodOrder> findAllFood() {
		return foodOrderDao.getAllFoodOrder();
	}
	@PutMapping
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderDao.updateFoodOrder(foodOrder);
	}
    @DeleteMapping
	public String delteteFoodById(@RequestParam int id) {
		Optional<FoodOrder>fo=foodOrderDao.getFoodOrder(id);
		if (fo.isPresent()) {
			
			foodOrderDao.deleteFoodOrder(id);
			return "food order id deleted";
		} else {
            return "food order is not found";
		}
	}
}

