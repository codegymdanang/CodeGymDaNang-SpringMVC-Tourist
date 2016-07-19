package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.FoodEntity;

public interface FoodEntityRepository extends JpaRepository<FoodEntity, Integer> {
	public List<FoodEntity> findAll();
}
