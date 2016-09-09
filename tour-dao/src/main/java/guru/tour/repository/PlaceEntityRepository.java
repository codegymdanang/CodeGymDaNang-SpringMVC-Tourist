package guru.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import guru.tour.entity.PlaceEntity;


public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Integer> {

	public PlaceEntity findById(int id);
	public PlaceEntity findByName(String placeName);
	//public PlaceEntity savePlaceEntity(PlaceEntity p);
	

	/*@Query("select a from place a WHERE a.local_id  = :local_id")*/	
	/*public List<PlaceEntity> getAllPlaceByLocalId(@Param("local_id") int local_id);*/
}
