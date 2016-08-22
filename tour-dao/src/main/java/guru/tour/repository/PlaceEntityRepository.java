package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.tour.entity.PlaceEntity;

public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Integer> {
	public PlaceEntity findById(int id);
	public PlaceEntity findByName(String placeName);
	//public PlaceEntity savePlaceEntity(PlaceEntity p);
	
}
