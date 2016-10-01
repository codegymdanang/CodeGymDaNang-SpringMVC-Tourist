package guru.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.tour.entity.FoodEntity;
import guru.tour.model.FoodModel;
@Service
public interface FoodEntityManager {
	
	public List<FoodEntity> getAllFoods();
	
	public List<FoodModel> getAllFoodModel();
	
	public List<FoodModel> getFoodByLocationId(String id);

	public FoodEntity findById(String id);
	
	public void saveFoodsEntity(FoodEntity food);

	public boolean isFoodEntity(FoodEntity food);

	public void updateFood(FoodEntity currentFood);
	
	public void deleteFoodById(String id);

	public void deleteAllFoods();
}
