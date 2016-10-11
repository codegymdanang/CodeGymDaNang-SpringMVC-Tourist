package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import guru.tour.entity.PlaceEntity;


public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Integer> {

	public PlaceEntity findById(String id);
	public PlaceEntity findByName(String placeName);
	//public PlaceEntity savePlaceEntity(PlaceEntity p);
	

	@Query("select a from PlaceEntity a WHERE a.location.locationId  = :local_id")	
	public List<PlaceEntity> getAllPlaceByLocalId(@Param("local_id") String local_id);
}
