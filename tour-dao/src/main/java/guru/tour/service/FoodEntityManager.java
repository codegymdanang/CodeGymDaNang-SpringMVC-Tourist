package guru.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.tour.entity.FoodEntity;
@Service
public interface FoodEntityManager {
	
	public List<FoodEntity> getAllFoods();

	public FoodEntity findById(int id);
	
	public void saveFoodsEntity(FoodEntity food);

	public boolean isFoodEntity(FoodEntity food);

	public void updateFood(FoodEntity currentFood);
	
	public void deleteFoodById(int id);

	public void deleteAllFoods();
}
