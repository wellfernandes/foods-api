package services;

import java.util.List;

import org.springframework.stereotype.Service;

import repositories.FoodResository;
import wellfernandes.com.github.foodsapi.model.Food;

@Service
public class FoodServices {

	private final FoodResository foodRepository;

	public FoodServices(FoodResository foodRepository) {
		this.foodRepository = foodRepository;
	}

	public List<Food> getAllFoods() {
		return foodRepository.findAll();
	}

	public Food getFoodById(Long id) throws Exception {
		return foodRepository.findById(id).orElseThrow(() -> new Exception("Food not found!"));
	}
	
	public Food saveFood(Food food) {
		return foodRepository.save(food);
	}
	
	public Food updateFood(Long id, Food newFood) throws Exception {
		Food food = getFoodById(id);
		food.setName(newFood.getName());
		return foodRepository.save(food);
	}
	
	public void deleteFoodById(Long id) throws Exception {
		Food food = getFoodById(id);
		foodRepository.delete(food);
	}
}
