package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.repository.FoodEntityRepository;
import guru.tour.entity.FoodEntity;
@Service

public class FoodEntityManagerImpl implements FoodEntityManager{
	@Autowired
	FoodEntityRepository foodEntityRepository;

	public List<FoodEntity> getAllFoods() {
		// TODO Auto-generated method stub
		return foodEntityRepository.findAll();
	}

	public FoodEntity findById(int id) {
		// TODO Auto-generated method stub
		return foodEntityRepository.findOne(id);
	}
	
	public void saveFoodsEntity(FoodEntity food) {
		foodEntityRepository.save(food);
	}

	public boolean isFoodEntity(FoodEntity food) {
		// TODO Auto-generated method stub
		List<FoodEntity> list = foodEntityRepository.findAll();

		if (list.contains(food)) {
			return true;
		}
		return false;
	}

	public void updateFood(FoodEntity currentFood) {
		// TODO Auto-generated method stub
		foodEntityRepository.saveAndFlush(currentFood);
		
	}

	public void deleteFoodById(int id) {
		// TODO Auto-generated method stub
		foodEntityRepository.delete(id);
		
	}

	public void deleteAllFoods() {
		// TODO Auto-generated method stub
		foodEntityRepository.deleteAll();
		
	}
	
}
