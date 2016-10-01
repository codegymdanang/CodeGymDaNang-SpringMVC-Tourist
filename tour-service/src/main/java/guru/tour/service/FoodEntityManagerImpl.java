package guru.tour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.repository.FoodEntityRepository;
import guru.tour.repository.LocationRepository;
import guru.tour.entity.FoodEntity;
import guru.tour.model.FoodModel;
import guru.tour.model.LocationModel;
@Service

public class FoodEntityManagerImpl implements FoodEntityManager{
	@Autowired
	FoodEntityRepository foodEntityRepository;
	
	@Autowired
	LocationRepository locationRepository;

	public List<FoodEntity> getAllFoods() {
		// TODO Auto-generated method stub
		return foodEntityRepository.findAll();
	}

	public FoodEntity findById(String id) {
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

	public void deleteFoodById(String id) {
		// TODO Auto-generated method stub
		foodEntityRepository.delete(id);
		
	}

	public void deleteAllFoods() {
		// TODO Auto-generated method stub
		foodEntityRepository.deleteAll();
		
	}
	
	public List<FoodModel> getAllFoodModel() {
		List<FoodEntity> listFood = getAllFoods();
		List<FoodModel> listModel = new ArrayList<FoodModel>();
		
		for (FoodEntity list : listFood) {
			LocationModel location= new LocationModel(list.getLocation().getLocationId(),list.getLocation().getLocationName());
			listModel.add(new FoodModel(list.getId(), list.getDescription(), list.getImages(), list.getName(), list.getPhone(), list.getPrice(), location));
		}
		return listModel;
	}

	@Override
	public List<FoodModel> getFoodByLocationId(String id) {
		// TODO Auto-generated method stub
		List<FoodModel> listModel = new ArrayList<FoodModel>();
		List<FoodEntity> listFood = foodEntityRepository.findByLocation(locationRepository.findOne(id));
		for (FoodEntity list : listFood) {
			LocationModel location= new LocationModel(list.getLocation().getLocationId(),list.getLocation().getLocationName());
			listModel.add(new FoodModel(list.getId(), list.getDescription(), list.getImages(), list.getName(), list.getPhone(), list.getPrice(), location));
		}
		return listModel;
	}
	
}
