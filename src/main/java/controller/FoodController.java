package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.FoodServices;

@RestController
@RequestMapping("/foods")
public class FoodController {

	private final FoodServices foodServices;

	public FoodController(FoodServices foodServices) {
		this.foodServices = foodServices;
	}
}
