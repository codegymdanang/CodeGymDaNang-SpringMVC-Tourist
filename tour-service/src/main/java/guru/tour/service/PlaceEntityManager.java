package guru.tour.service;

import java.util.List;

import guru.tour.entity.PlaceEntity;

public interface PlaceEntityManager {
	public List<PlaceEntity> getAll();

	public PlaceEntity getPlaceByID(String id);
	
	public boolean isPlaceExist(PlaceEntity p);
	
	public PlaceEntity addPlace(PlaceEntity p);
	
	public PlaceEntity updatePlace(PlaceEntity p);
	
	public void deletePlace(String id);

	public PlaceEntity getPlaceByName(String placeName);

	public List<PlaceEntity> getAllPlaceByLocalId(String local_id);
	
}
