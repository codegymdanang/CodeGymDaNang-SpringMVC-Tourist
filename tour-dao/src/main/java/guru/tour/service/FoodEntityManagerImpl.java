package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import guru.tour.entity.FoodEntity;
import guru.tour.repository.FoodEntityRepository;
@Service

public class FoodEntityManagerImpl implements FoodEntityManager{
	@Autowired
	FoodEntityRepository foodEntityRepository;
	public List<FoodEntity> getAllHotel() {
		return foodEntityRepository.findAll();
	}
}
