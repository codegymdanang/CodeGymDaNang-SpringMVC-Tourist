package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.tour.entity.PlaceEntity;


public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Integer> {

	public PlaceEntity findById(String id);
	public PlaceEntity findByName(String placeName);
	//public PlaceEntity savePlaceEntity(PlaceEntity p);
	

	/*@Query("select a from place a WHERE a.local_id  = :local_id")*/	
	/*public List<PlaceEntity> getAllPlaceByLocalId(@Param("local_id") int local_id);*/
}
