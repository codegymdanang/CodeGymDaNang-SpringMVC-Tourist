package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.FoodEntity;
import guru.tour.entity.LocationEntity;

public interface FoodEntityRepository extends JpaRepository<FoodEntity, String> {
	public List<FoodEntity> findByLocation(LocationEntity localId);
}
