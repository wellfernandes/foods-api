package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.FoodServices;
import wellfernandes.com.github.foodsapi.model.Food;

@RestController
@RequestMapping("/foods")
public class FoodController {

	private final FoodServices foodServices;

	public FoodController(FoodServices foodServices) {
		this.foodServices = foodServices;
	}

	@GetMapping
	public List<Food> listAll() {
		return foodServices.getAllFoods();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
		try {
			Food food = foodServices.getFoodById(id);
			return ResponseEntity.ok(food);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
}
