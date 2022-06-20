package controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public Food createFood(@RequestBody Food food) {
		return foodServices.saveFood(food);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
		try {
			Food updatedFood = foodServices.updateFood(id, food);
			return ResponseEntity.ok(updatedFood);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> deleteFood(@PathVariable Long id) {
		try {
			foodServices.deleteFoodById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
