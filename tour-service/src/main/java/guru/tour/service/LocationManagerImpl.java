package guru.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.tour.entity.LocationEntity;
import guru.tour.repository.LocationRepository;
@Service
public class LocationManagerImpl implements LocationEntityManager{

	@Autowired
	LocationRepository lr;
	
	public List<LocationEntity> getLocation() {
		return lr.findAll();
	}

	public LocationEntity findByLocation_name(String locationName) {
		return lr.findByLocationName(locationName);
	}
	
}
