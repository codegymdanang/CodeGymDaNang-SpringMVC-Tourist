package guru.tour.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import guru.tour.entity.LocationEntity;

public interface LocationEntityManager {
	@Query("Select a from location a")
	public List<LocationEntity> getLocation();

	public LocationEntity findByLocation_name(String locationName);
}
