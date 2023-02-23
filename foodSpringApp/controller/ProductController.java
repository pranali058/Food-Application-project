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

import com.food.foodSpringApp.dao.ProductDao;
import com.food.foodSpringApp.dto.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@PostMapping
	public Product saveProoduct(@RequestBody Product product) {
		return productDao.saveProduct(product);
	}
	
	
	
	
	
	/*
	 * @GetMapping public Product getProductById(@RequestParam int id) {
	 * Optional<Product>po=productDao.getProductById(id); if(po.isEmpty()) { return
	 * null; }else { return po.get(); } }
	 */
	 
	
	@GetMapping
	public List<Product> getAll() {
		return productDao.getAllProduct();
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product pro) {
		return productDao.updateProduct(pro);
	}
	
	/*
	 * @DeleteMapping public String deleteProduct(@RequestParam int id) {
	 * Optional<Product>op=productDao.getProductById(id); if (op.isPresent()) {
	 * productDao.deletePro(id); return "prouct data deleted"; } else { return
	 * "product data not found"; } }
	 */
}
