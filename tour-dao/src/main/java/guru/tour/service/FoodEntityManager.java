package guru.tour.service;

import java.util.List;

import guru.tour.entity.FoodEntity;

public interface FoodEntityManager {
	public List<FoodEntity> findAll();
}
