package guru.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import guru.tour.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity ,String>{
		public LocationEntity findByLocationName(String locationName);	
}


