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

}
