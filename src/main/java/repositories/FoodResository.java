package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wellfernandes.com.github.foodsapi.model.Food;

@Repository
public interface FoodResository extends JpaRepository<Food, Long> {

}
